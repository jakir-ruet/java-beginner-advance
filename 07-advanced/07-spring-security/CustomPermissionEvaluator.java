package com.example.secureapi.security;

import com.example.secureapi.entity.User;
import com.example.secureapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RequiredArgsConstructor
public class CustomPermissionEvaluator implements PermissionEvaluator {

    private final UserRepository userRepository;

    @Override
    public boolean hasPermission(Authentication authentication,
                                Object targetDomainObject,
                                Object permission) {

        if (authentication == null || targetDomainObject == null) {
            return false;
        }

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        // Check if user is owner of the resource
        if (targetDomainObject instanceof OwnedResource) {
            OwnedResource resource = (OwnedResource) targetDomainObject;
            if (permission.equals("WRITE") && resource.getOwnerId().equals(userPrincipal.getId())) {
                return true;
            }
        }

        // Check user's authorities
        return authentication.getAuthorities().stream()
            .anyMatch(authority -> authority.getAuthority().equals(permission));
    }

    @Override
    public boolean hasPermission(Authentication authentication,
                                Serializable targetId,
                                String targetType,
                                Object permission) {

        if (authentication == null) {
            return false;
        }

        // For ID-based permission checking
        if (targetType.equals("User") && permission.equals("WRITE")) {
            User targetUser = userRepository.findById((Long) targetId).orElse(null);
            if (targetUser != null) {
                UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
                return targetUser.getId().equals(userPrincipal.getId());
            }
        }

        return false;
    }
}

// Interface for owned resources
public interface OwnedResource {
    Long getOwnerId();
}
