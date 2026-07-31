package com.jakirbd.cors_csrf_backend_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/myLoan")
    public String getLoanDetails() {
        return "Loan Details";
    }
}
