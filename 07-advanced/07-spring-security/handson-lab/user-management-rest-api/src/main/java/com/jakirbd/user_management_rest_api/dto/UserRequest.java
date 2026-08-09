package com.jakirbd.user_management_rest_api.dto;

public record UserRequest(

        String username,

        String password,

        String authority

) {}