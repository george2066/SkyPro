package com.example.employee.services.interfaces;

import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee removeEmployee(String passport);
    Employee findEmployee(String passport);
    Map<String, Employee> findAll();
}
