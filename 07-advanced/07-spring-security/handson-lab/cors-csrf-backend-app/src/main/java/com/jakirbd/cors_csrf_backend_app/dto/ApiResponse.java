package com.jakirbd.cors_csrf_backend_app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ApiResponse {


    private String status;


    private String message;


    private Object data;

}