package com.example.employee.controllers;

import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;
import com.example.employee.exceptions.EmployeeAddedException;
import com.example.employee.services.interfaces.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer departmentId,
            @RequestParam("passport") String passport
    ) {
        try {
            Department department = new Department(departmentId);
            Employee employee = new Employee(name, surname, salary, department, passport);
            return service.addEmployee(employee);
        } catch (EmployeeAddedException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("passport") String passport) {
        try {
            return service.removeEmployee(passport);
        } catch (EmployeeAddedException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("passport") String passport) {
        try {
            return service.findEmployee(passport);
        } catch (EmployeeAddedException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/findAll")
    public Map<String, Employee> findAll() {
        return service.findAll();
    }
}
