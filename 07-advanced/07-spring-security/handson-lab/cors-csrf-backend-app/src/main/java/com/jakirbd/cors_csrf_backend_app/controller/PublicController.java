package com.jakirbd.cors_csrf_backend_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {


    @GetMapping("/contact")
    public String contact() {
        return "Contact page - public access";

    }

    @GetMapping("/notice")
    public String notice() {
        return "Notice page - public access";
    }
}