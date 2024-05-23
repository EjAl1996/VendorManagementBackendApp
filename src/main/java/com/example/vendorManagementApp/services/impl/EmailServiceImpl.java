package com.example.vendorManagementApp.services.impl;

import com.example.vendorManagementApp.entities.Email;
import com.example.vendorManagementApp.entities.Vendor;
import com.example.vendorManagementApp.repositories.EmailRepo;
import com.example.vendorManagementApp.repositories.EmployeeRepo;
import com.example.vendorManagementApp.repositories.VendorRepo;
import com.example.vendorManagementApp.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private VendorRepo vendorRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmailRepo emailRepo;



    public ResponseEntity<String> sendEmail(String recipientEmail, String subject) {
        boolean ispresent = Emailvarifier(recipientEmail);
        if (ispresent) {
            Vendor vendor = vendorRepo.findByEmail(recipientEmail);
            String upis = vendor.getUpi();
            String name = vendor.getName();

            String emailBody = String.format("Sending payments to vendor %s at upi %s", name, upis);



            Email email = new Email();
            email.setRecipientEmail(recipientEmail);
            email.setSubject(subject);
            email.setBody(emailBody);
            email.setSentAt(LocalDateTime.now());
            emailRepo.save(email);
            System.out.println("Email sent to " + recipientEmail + " with body: " + emailBody);
            return new ResponseEntity<>("Email sent", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Email not found", HttpStatus.NOT_FOUND);
        }

    }




    @Override
    public List<Email> findAll() {
        return emailRepo.findAll();
    }



    @Override
    public Boolean Emailvarifier(String email) {

         Vendor vendor = vendorRepo.findByEmail(email);
        return vendor != null;

    }


}
