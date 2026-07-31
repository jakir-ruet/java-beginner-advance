package com.jakirbd.cors_csrf_backend_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class CsrfConfig {

    public void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
    }
}