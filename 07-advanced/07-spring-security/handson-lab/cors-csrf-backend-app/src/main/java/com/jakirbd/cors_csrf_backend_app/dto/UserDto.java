package com.jakirbd.cors_csrf_backend_app.dto;


import lombok.Data;

import java.util.List;


@Data
public class UserDto {


    private String username;


    private String enabled;


    private List<AuthorityDto> authorities;

}