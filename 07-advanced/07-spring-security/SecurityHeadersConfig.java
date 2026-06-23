package com.example.secureapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.writers.*;

@Configuration
public class SecurityHeadersConfig {

    @Bean
    public HeaderWriter securityHeadersWriter() {
        return (request, response) -> {
            // Content Security Policy
            response.setHeader("Content-Security-Policy",
                "default-src 'self'; " +
                "script-src 'self' 'unsafe-inline' 'unsafe-eval' https://trusted-cdn.com; " +
                "style-src 'self' 'unsafe-inline'; " +
                "img-src 'self' data: https:; " +
                "font-src 'self'; " +
                "connect-src 'self' https://api.example.com; " +
                "frame-ancestors 'none'; " +
                "base-uri 'self'; " +
                "form-action 'self'");

            // XSS Protection
            response.setHeader("X-XSS-Protection", "1; mode=block");

            // Content Type Options (prevents MIME sniffing)
            response.setHeader("X-Content-Type-Options", "nosniff");

            // Frame Options (prevents clickjacking)
            response.setHeader("X-Frame-Options", "DENY");

            // Referrer Policy
            response.setHeader("Referrer-Policy", "strict-origin-when-cross-origin");

            // Permissions Policy
            response.setHeader("Permissions-Policy",
                "geolocation=(), microphone=(), camera=(), payment=(), usb=()");

            // Cache Control
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");

            // HSTS - Only in production with HTTPS
            if (request.isSecure()) {
                response.setHeader("Strict-Transport-Security",
                    "max-age=31536000; includeSubDomains; preload");
            }
        };
    }
}
