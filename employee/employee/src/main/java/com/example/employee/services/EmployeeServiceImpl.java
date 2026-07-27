package com.example.employee.services;

import com.example.employee.Employee;
import com.example.employee.exceptions.EmployeeAlreadyAddedException;
import com.example.employee.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl(HashMap<String, Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        String fio = employee.getName() + " " + employee.getSurname();
        if (employees.containsKey(fio)) {
            throw new EmployeeAlreadyAddedException("Such employee already exists");
        }
        employees.put(fio, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        String fio = employee.getName() + " " + employee.getSurname();
        if (employees.containsKey(fio)) {
            employees.remove(fio);
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmployee(String firstname, String lastName) {
        Employee employee = new Employee(firstname, lastName);
        String fio = employee.getName() + " " + employee.getSurname();
        if (employees.containsKey(fio)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Map<String, Employee> findAll() {
        return employees;
    }
}
