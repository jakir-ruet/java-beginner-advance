package com.example.secureapi.security;

import com.example.secureapi.service.AuditService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component
@Order(2)
@RequiredArgsConstructor
@Slf4j
public class AuditLogFilter extends OncePerRequestFilter {

    private final AuditService auditService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();

        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            long duration = System.currentTimeMillis() - startTime;

            // Log only security-relevant endpoints
            if (isSecurityRelevant(request.getRequestURI())) {
                auditService.logRequest(
                    requestWrapper,
                    responseWrapper,
                    duration
                );
            }

            responseWrapper.copyBodyToResponse();
        }
    }

    private boolean isSecurityRelevant(String uri) {
        return uri.contains("/login") ||
               uri.contains("/register") ||
               uri.contains("/logout") ||
               uri.contains("/reset-password") ||
               uri.contains("/change-password") ||
               uri.contains("/admin") ||
               uri.contains("/user") ||
               uri.startsWith("/api/");
    }
}
