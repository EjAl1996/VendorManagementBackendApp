package com.example.vendorManagementApp.utility;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class AdminCheck {
    public static void checkAdmin(String adminHeader) {
        if (!"Admin".equals(adminHeader)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access Forbidden ! you are not an Admin");
        }
    }

}
