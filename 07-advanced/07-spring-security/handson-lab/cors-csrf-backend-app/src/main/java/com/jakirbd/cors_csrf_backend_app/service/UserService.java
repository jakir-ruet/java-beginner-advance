package com.jakirbd.cors_csrf_backend_app.service;

import com.jakirbd.cors_csrf_backend_app.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    User save(User user);

    void deleteByUsername(String username);
}