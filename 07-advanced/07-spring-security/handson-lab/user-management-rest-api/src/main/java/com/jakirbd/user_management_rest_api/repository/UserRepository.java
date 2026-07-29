package com.jakirbd.user_management_rest_api.repository;

import com.jakirbd.user_management_rest_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository
        extends JpaRepository<User, String> {

}