package com.example.vendorManagementApp.services;

import com.example.vendorManagementApp.entities.Vendor;

import java.util.List;


public interface VendorService {

    List<Vendor> findAll();

    Vendor saveVendor(Vendor vendor);
}
