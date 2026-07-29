package com.jakirbd.user_management_rest_api.dto;


import java.util.List;


public record UserResponse(

        String username,

        String enabled,

        List<String> roles

) {}