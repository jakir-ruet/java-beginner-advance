package com.example.secureapi.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PasswordValidator {

    // OWASP recommends:
    // - Minimum 12 characters
    // - Include uppercase, lowercase, numbers, special characters
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{12,}$"
    );

    private static final int MIN_LENGTH = 12;
    private static final int MAX_LENGTH = 128;

    public boolean isValid(String password) {
        if (password == null || password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean isCommonPassword(String password) {
        // Check against common password list
        // This should be loaded from a file or database
        String[] commonPasswords = {
            "password123", "admin123", "qwerty123", "12345678"
        };

        for (String common : commonPasswords) {
            if (common.equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }
}
