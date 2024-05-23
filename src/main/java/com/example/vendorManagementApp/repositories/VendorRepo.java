package com.example.vendorManagementApp.repositories;

import com.example.vendorManagementApp.entities.Employee;
import com.example.vendorManagementApp.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Long> {
    Vendor findByEmail(String email);
}
