package com.example.vendorManagementApp.services;

import com.example.vendorManagementApp.entities.Employee;
import com.example.vendorManagementApp.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();

    Employee saveEmployee(Employee employee);

}
