package com.example.vendorManagementApp.services.impl;

import com.example.vendorManagementApp.entities.Admin;
import com.example.vendorManagementApp.repositories.AdminRepo;
import com.example.vendorManagementApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Admin save(Admin admin) {
         return adminRepo.save(admin);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepo.findByUsername(username).orElse(null);
    }

    @Override
    public boolean validateAdmin(String username, String password) {
        Optional<Admin> admin = adminRepo.findByUsername(username);
        return admin.isPresent() && admin.get().getPassword().equals(password);
    }
}
