package com.example.employee.services;

import com.example.employee.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstname, String lastName);
    Employee removeEmployee(String firstname, String lastName);
    Employee findEmployee(String firstname, String lastName);
    Map<String, Employee> findAll();
}
