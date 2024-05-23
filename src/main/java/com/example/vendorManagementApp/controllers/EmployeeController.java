package com.example.vendorManagementApp.controllers;

import com.example.vendorManagementApp.entities.Employee;
import com.example.vendorManagementApp.services.EmployeeService;
import com.example.vendorManagementApp.utility.AdminCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public void createEmployee(@RequestHeader(value = "Admin") String adminHeader, @RequestBody Employee employee) {
        AdminCheck.checkAdmin(adminHeader);
        service.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }
}
