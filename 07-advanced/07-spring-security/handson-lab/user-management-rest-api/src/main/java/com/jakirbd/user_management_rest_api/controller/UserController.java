package com.jakirbd.user_management_rest_api.controller;


import com.jakirbd.user_management_rest_api.dto.UserResponse;
import com.jakirbd.user_management_rest_api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public List<UserResponse> getUsers(){

        return service.findAll();

    }

}