package com.jakirbd.user_management_rest_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {


    // ==================== Security Configuration ====================

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(
            HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/contact",
                                "/notice",
                                "/error"
                        )
                        .permitAll()
                        .requestMatchers(
                                "/api/users/**",
                                "/myAccount",
                                "/myBalance",
                                "/myCard",
                                "/myLoan"
                        )
                        .authenticated()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // ==================== Oracle JDBC Authentication ====================
    @Bean
    public UserDetailsService userDetailsService(
            DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    // ==================== BCrypt Password Encoder ====================
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}