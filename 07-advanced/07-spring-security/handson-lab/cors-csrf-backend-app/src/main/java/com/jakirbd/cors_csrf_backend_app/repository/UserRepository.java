package com.jakirbd.cors_csrf_backend_app.repository;

import com.jakirbd.cors_csrf_backend_app.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);
}