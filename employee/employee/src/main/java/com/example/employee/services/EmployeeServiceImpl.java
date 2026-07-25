package com.example.employee.services;

import com.example.employee.Employee;
import com.example.employee.exceptions.EmployeeAlreadyAddedException;
import com.example.employee.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Such employee already exists");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public List<Object> findAll() {
        return Collections.unmodifiableList(employees);
    }
}
