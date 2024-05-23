package com.example.vendorManagementApp.services.impl;

import com.example.vendorManagementApp.entities.Vendor;
import com.example.vendorManagementApp.repositories.VendorRepo;
import com.example.vendorManagementApp.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

//    public void save(Vendor vendor) {
//        vendorRepo.save(vendor);
//    }

    public List<Vendor> findAll() {
        return vendorRepo.findAll();
    }

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return  vendorRepo.save(vendor);
    }
}
