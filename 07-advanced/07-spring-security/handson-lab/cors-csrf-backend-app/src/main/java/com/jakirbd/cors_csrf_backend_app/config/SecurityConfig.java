package com.jakirbd.cors_csrf_backend_app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    private final CsrfConfig csrfConfig;

    public SecurityConfig(CsrfConfig csrfConfig) {
        this.csrfConfig = csrfConfig;
    }


    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        csrfConfig.configure(http);
        http
                .cors(Customizer.withDefaults())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/contact",
                                "/notice"
                        )
                        .permitAll()

                        .requestMatchers(
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

    @Bean
    UserDetailsService userDetailsService(
            DataSource dataSource) {

        JdbcUserDetailsManager jdbc =
                new JdbcUserDetailsManager(dataSource);
        jdbc.setUsersByUsernameQuery(
                """
                SELECT
                    username,
                    password,
                    enabled
                FROM users
                WHERE username = ?
                """
        );
        jdbc.setAuthoritiesByUsernameQuery(
                """
                SELECT
                    username,
                    authority
                FROM authorities
                WHERE username = ?
                """
        );
        return jdbc;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}