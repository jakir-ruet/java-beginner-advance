package com.jakirbd.cors_csrf_backend_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @GetMapping("/myCard")
    public String getCardDetails() {
        return "Card Details";
    }
}
