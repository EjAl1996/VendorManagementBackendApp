package com.example.vendorManagementApp.services;

import com.example.vendorManagementApp.entities.Admin;

public interface AdminService {

    Admin save(Admin admin);
    Admin findByUsername(String username);
    boolean validateAdmin(String username, String password);
}
