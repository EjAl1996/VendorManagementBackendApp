package com.example.vendorManagementApp.controllers;

import com.example.vendorManagementApp.entities.Vendor;
import com.example.vendorManagementApp.services.VendorService;
import com.example.vendorManagementApp.utility.AdminCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService service;

    @PostMapping
    public void createVendor(@RequestHeader(value = "Admin") String adminHeader, @RequestBody Vendor vendor) {
        AdminCheck.checkAdmin(adminHeader);
        service.saveVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.findAll();
    }
}
