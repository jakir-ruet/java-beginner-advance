package com.example.secureapi.service;

import com.example.secureapi.entity.AuditLog;
import com.example.secureapi.repository.AuditLogRepository;
import com.example.secureapi.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuditService {

    private final AuditLogRepository auditLogRepository;

    public void logRequest(ContentCachingRequestWrapper request,
                          ContentCachingResponseWrapper response,
                          long duration) {

        String username = getCurrentUsername();
        String action = determineAction(request.getRequestURI(), request.getMethod());
        String details = buildDetails(request, response, duration);
        InetAddress ipAddress = getClientIp(request);
        String userAgent = request.getHeader("User-Agent");
        String status = response.getStatus() < 400 ? "SUCCESS" : "FAILURE";

        AuditLog auditLog = AuditLog.builder()
            .username(username)
            .action(action)
            .details(details)
            .ipAddress(ipAddress)
            .userAgent(userAgent)
            .status(status)
            .build();

        auditLogRepository.save(auditLog);

        // Also log to application log for real-time monitoring
        log.info("AUDIT: User={}, Action={}, Status={}, IP={}, Duration={}ms",
            username, action, status, ipAddress, duration);
    }

    public void log(String action, String details, String status) {
        log(action, details, status, null, null);
    }

    public void log(String action, String details, String status,
                   String ipAddress, String userAgent) {
        AuditLog auditLog = AuditLog.builder()
            .username(getCurrentUsername())
            .action(action)
            .details(details)
            .status(status)
            .build();

        if (ipAddress != null) {
            try {
                auditLog.setIpAddress(InetAddress.getByName(ipAddress));
            } catch (Exception e) {
                // Ignore
            }
        }

        auditLog.setUserAgent(userAgent);
        auditLogRepository.save(auditLog);

        log.info("AUDIT: User={}, Action={}, Status={}",
            getCurrentUsername(), action, status);
    }

    private String determineAction(String uri, String method) {
        if (uri.contains("/login")) return "LOGIN";
        if (uri.contains("/logout")) return "LOGOUT";
        if (uri.contains("/register")) return "REGISTER";
        if (uri.contains("/reset-password")) return "PASSWORD_RESET";
        if (uri.contains("/change-password")) return "PASSWORD_CHANGE";
        if (uri.contains("/admin")) return "ADMIN_ACTION";
        if (uri.contains("/user")) return "USER_ACTION";
        return method + " " + uri;
    }

    private String buildDetails(ContentCachingRequestWrapper request,
                                ContentCachingResponseWrapper response,
                                long duration) {
        StringBuilder details = new StringBuilder();
        details.append("Method: ").append(request.getMethod()).append(", ");
        details.append("URI: ").append(request.getRequestURI()).append(", ");
        details.append("Status: ").append(response.getStatus()).append(", ");
        details.append("Duration: ").append(duration).append("ms");

        // Log request parameters (excluding passwords)
        if (request.getParameterMap() != null && !request.getParameterMap().isEmpty()) {
            details.append(", Params: ");
            request.getParameterMap().forEach((key, value) -> {
                if (!key.toLowerCase().contains("password")) {
                    details.append(key).append("=").append(String.join(",", value)).append("; ");
                }
            });
        }

        return details.toString();
    }

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserPrincipal) {
                return ((UserPrincipal) principal).getUsername();
            } else if (principal instanceof String) {
                return (String) principal;
            }
        }
        return "ANONYMOUS";
    }

    private InetAddress getClientIp(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            try {
                return InetAddress.getByName(xForwardedFor.split(",")[0].trim());
            } catch (Exception e) {
                // Ignore
            }
        }

        try {
            return InetAddress.getByName(request.getRemoteAddr());
        } catch (Exception e) {
            return null;
        }
    }
}
