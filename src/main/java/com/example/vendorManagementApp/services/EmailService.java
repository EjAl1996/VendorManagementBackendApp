package com.example.vendorManagementApp.services;

import com.example.vendorManagementApp.entities.Email;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EmailService {

    ResponseEntity<String> sendEmail(String recipientEmail, String subject);

    List<Email> findAll();

    Boolean Emailvarifier(String email);


}
