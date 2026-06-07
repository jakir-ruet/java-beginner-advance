package com.example.secureapi.security;

import com.example.secureapi.service.RateLimiterService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
@RequiredArgsConstructor
@Slf4j
public class RateLimitingFilter extends OncePerRequestFilter {

    private final RateLimiterService rateLimiterService;

    @Value("${rate-limit.enabled:true}")
    private boolean rateLimitEnabled;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (!rateLimitEnabled) {
            filterChain.doFilter(request, response);
            return;
        }

        String clientIp = getClientIp(request);
        String endpoint = request.getRequestURI();
        String key = clientIp + ":" + endpoint;

        // Different rate limits for different endpoints
        int limit = getRateLimit(endpoint);
        String timeUnit = "hour";

        if (endpoint.contains("/login")) {
            limit = 5;
            timeUnit = "15min";
        } else if (endpoint.contains("/register")) {
            limit = 3;
            timeUnit = "hour";
        } else if (endpoint.contains("/api/")) {
            limit = 1000;
            timeUnit = "hour";
        }

        if (!rateLimiterService.isAllowed(key, limit, timeUnit)) {
            log.warn("Rate limit exceeded for IP: {} on endpoint: {}", clientIp, endpoint);
            response.setStatus(429);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"Too many requests. Please try again later.\"}");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private int getRateLimit(String endpoint) {
        if (endpoint.contains("/login")) return 5;
        if (endpoint.contains("/register")) return 3;
        if (endpoint.contains("/reset-password")) return 3;
        if (endpoint.contains("/api/")) return 1000;
        return 100;
    }

    private String getClientIp(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0].trim();
        }
        return request.getRemoteAddr();
    }
}
