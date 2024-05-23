package com.example.vendorManagementApp.repositories;

import com.example.vendorManagementApp.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {

}
