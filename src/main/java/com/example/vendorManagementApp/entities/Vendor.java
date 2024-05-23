package com.example.vendorManagementApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String upi;
    private String name;
    private String email;

    @PrePersist
    public void generateUpi() {
        // Generate UUID for upi
        this.upi = UUID.randomUUID().toString();
    }

    // Constructor with email argument
    public Vendor(String email) {
        this.email = email;
    }
}
