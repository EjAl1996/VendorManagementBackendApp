package com.example.vendorManagementApp.repositories;

import com.example.vendorManagementApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    boolean findByEmail(String email);
}
