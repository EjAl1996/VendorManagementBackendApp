package com.example.vendorManagementApp.controllers;

import com.example.vendorManagementApp.entities.Email;
import com.example.vendorManagementApp.services.EmailService;
import com.example.vendorManagementApp.utility.AdminCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestHeader(value = "Admin") String adminHeader, @RequestParam String recipientEmail, @RequestParam String subject) {
        AdminCheck.checkAdmin(adminHeader);
        return emailService.sendEmail(recipientEmail, subject);
    }

    @GetMapping
    public List<Email> getAllEmails(@RequestHeader(value = "Admin") String adminHeader) {
        AdminCheck.checkAdmin(adminHeader);
        return emailService.findAll();
    }
}