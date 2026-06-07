package com.example.secureapi.service;

import com.example.secureapi.dto.*;
import com.example.secureapi.entity.*;
import com.example.secureapi.repository.*;
import com.example.secureapi.security.JwtService;
import com.example.secureapi.security.UserPrincipal;
import com.example.secureapi.util.AuditLogger;
import com.example.secureapi.util.PasswordValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuditLogger auditLogger;
    private final EmailService emailService;
    private final TwoFactorService twoFactorService;
    private final PasswordValidator passwordValidator;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        // Validate input
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username is already taken");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

        if (!passwordValidator.isValid(request.getPassword())) {
            throw new RuntimeException("Password does not meet security requirements");
        }

        // Create user
        User user = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .enabled(true)
            .accountNonLocked(true)
            .failedAttempts(0)
            .passwordChangedAt(LocalDateTime.now())
            .build();

        // Assign default role
        Role userRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRoles(new HashSet<>(Set.of(userRole)));

        User savedUser = userRepository.save(user);

        // Send verification email
        emailService.sendVerificationEmail(savedUser);

        // Log registration
        auditLogger.log("USER_REGISTER",
            String.format("User %s registered", savedUser.getUsername()),
            "SUCCESS");

        // Auto-login after registration
        Authentication authentication = authenticate(request.getUsername(), request.getPassword());
        String accessToken = jwtService.generateAccessToken(authentication);
        String refreshToken = jwtService.generateRefreshToken(
            request.getUsername(),
            savedUser.getId()
        );

        // Save refresh token
        saveRefreshToken(savedUser, refreshToken);

        return AuthenticationResponse.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken)
            .tokenType("Bearer")
            .user(convertToDto(savedUser))
            .build();
    }

    @Transactional
    public AuthenticationResponse login(LoginRequest request, String ipAddress, String userAgent) {
        try {
            // Check account lock status
            User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

            if (!user.isAccountNonLocked()) {
                auditLogger.log("LOGIN_FAILED",
                    String.format("Locked account attempted login: %s", request.getUsername()),
                    "FAILURE", ipAddress, userAgent);
                throw new RuntimeException("Account is locked. Please contact administrator");
            }

            // Authenticate
            Authentication authentication = authenticate(request.getUsername(), request.getPassword());

            // Reset failed attempts
            user.setFailedAttempts(0);
            user.setLastLogin(LocalDateTime.now());
            userRepository.save(user);

            // Set security context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Generate tokens
            String accessToken = jwtService.generateAccessToken(authentication);
            String refreshToken = jwtService.generateRefreshToken(
                request.getUsername(),
                user.getId()
            );

            // Save refresh token
            saveRefreshToken(user, refreshToken);

            // Check if 2FA is enabled
            boolean requires2FA = user.isTwoFactorEnabled();

            // Log successful login
            auditLogger.log("LOGIN_SUCCESS",
                String.format("User %s logged in successfully", request.getUsername()),
                "SUCCESS", ipAddress, userAgent);

            return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .requiresTwoFactor(requires2FA)
                .user(convertToDto(user))
                .build();

        } catch (BadCredentialsException e) {
            // Increment failed attempts
            userRepository.findByUsername(request.getUsername()).ifPresent(user -> {
                int attempts = user.getFailedAttempts() + 1;
                user.setFailedAttempts(attempts);

                if (attempts >= 5) {
                    user.setAccountNonLocked(false);
                    auditLogger.log("ACCOUNT_LOCKED",
                        String.format("Account locked after %d failed attempts", attempts),
                        "FAILURE", ipAddress, userAgent);
                }

                userRepository.save(user);
            });

            auditLogger.log("LOGIN_FAILED",
                String.format("Failed login attempt for user: %s", request.getUsername()),
                "FAILURE", ipAddress, userAgent);

            throw new RuntimeException("Invalid username or password");
        }
    }

    private Authentication authenticate(String username, String password) {
        return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
    }

    @Transactional
    public AuthenticationResponse refreshToken(String refreshToken) {
        if (!jwtService.validateToken(refreshToken) || !jwtService.isRefreshToken(refreshToken)) {
            throw new RuntimeException("Invalid refresh token");
        }

        String username = jwtService.extractUsername(refreshToken);
        Long userId = jwtService.extractUserId(refreshToken);

        // Verify refresh token exists and is not revoked
        RefreshToken storedToken = refreshTokenRepository.findByToken(refreshToken)
            .orElseThrow(() -> new RuntimeException("Refresh token not found"));

        if (storedToken.isRevoked() || storedToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Refresh token expired or revoked");
        }

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Create new authentication
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());

        String newAccessToken = jwtService.generateAccessToken(authentication);

        return AuthenticationResponse.builder()
            .accessToken(newAccessToken)
            .refreshToken(refreshToken)
            .tokenType("Bearer")
            .user(convertToDto(user))
            .build();
    }

    @Transactional
    public void logout(String refreshToken) {
        if (refreshToken != null) {
            refreshTokenRepository.findByToken(refreshToken).ifPresent(token -> {
                token.setRevoked(true);
                refreshTokenRepository.save(token);
            });
        }

        SecurityContextHolder.clearContext();
        auditLogger.log("LOGOUT", "User logged out", "SUCCESS");
    }

    @Transactional
    public void changePassword(ChangePasswordRequest request, String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Verify current password
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new RuntimeException("Current password is incorrect");
        }

        // Validate new password
        if (!passwordValidator.isValid(request.getNewPassword())) {
            throw new RuntimeException("New password does not meet security requirements");
        }

        // Check password history (prevent reuse of last 5 passwords)
        // This would require a password history table

        // Update password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        user.setPasswordChangedAt(LocalDateTime.now());
        userRepository.save(user);

        // Revoke all refresh tokens
        refreshTokenRepository.revokeAllUserTokens(user.getId());

        auditLogger.log("PASSWORD_CHANGED",
            String.format("User %s changed password", username),
            "SUCCESS");
    }

    @Transactional
    public void forgotPassword(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = PasswordResetToken.builder()
            .user(user)
            .token(token)
            .expiresAt(LocalDateTime.now().plusHours(24))
            .used(false)
            .build();

        passwordResetTokenRepository.save(resetToken);
        emailService.sendPasswordResetEmail(user, token);

        auditLogger.log("PASSWORD_RESET_REQUESTED",
            String.format("Password reset requested for user: %s", email),
            "SUCCESS");
    }

    @Transactional
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token)
            .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (resetToken.isUsed() || resetToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired or already used");
        }

        if (!passwordValidator.isValid(newPassword)) {
            throw new RuntimeException("Password does not meet security requirements");
        }

        User user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setPasswordChangedAt(LocalDateTime.now());
        userRepository.save(user);

        resetToken.setUsed(true);
        passwordResetTokenRepository.save(resetToken);

        // Revoke all refresh tokens
        refreshTokenRepository.revokeAllUserTokens(user.getId());

        auditLogger.log("PASSWORD_RESET",
            String.format("Password reset completed for user: %s", user.getUsername()),
            "SUCCESS");
    }

    private void saveRefreshToken(User user, String token) {
        RefreshToken refreshToken = RefreshToken.builder()
            .user(user)
            .token(token)
            .expiresAt(LocalDateTime.now().plusDays(7))
            .revoked(false)
            .build();

        refreshTokenRepository.save(refreshToken);
    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .roles(user.getRoles().stream()
                .map(Role::getName)
                .collect(java.util.stream.Collectors.toSet()))
            .twoFactorEnabled(user.isTwoFactorEnabled())
            .build();
    }
}
