package com.example.employee;

import com.example.employee.exceptions.DepartmentNotExistException;
import com.example.employee.exceptions.EmployeeAddedException;
import com.example.employee.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("salary") Integer salary,
            @RequestParam("department") Integer department,
            @RequestParam("passport") String passport
    ) {
        try {
            return employeeService.addEmployee(name, surname, salary, department, passport);
        } catch (EmployeeAddedException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("passport") String passport) {
        try {
            return employeeService.removeEmployee(passport);
        } catch (EmployeeAddedException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("passport") String passport) {
        try {
            return employeeService.findEmployee(passport);
        } catch (EmployeeAddedException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/findAll")
    public Map<String, Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/departments/max-salary")
    public Integer maxSalaryOfDepartment(
            @RequestParam("departmentId") Integer departmentId
    ) {
        try {
            return employeeService.maxSalaryOfDepartment(departmentId);
        } catch (DepartmentNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/departments/min-salary")
    public Integer minSalaryOfDepartment(
            @RequestParam("departmentId") Integer departmentId
    ) {
        try {
            return employeeService.minSalaryOfDepartment(departmentId);
        } catch (DepartmentNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/departments/employees")
    public List<Employee> employeesDepartment(
            @RequestParam("departmentId") Integer departmentId
    ) {
        try {
            return employeeService.employeesDepartment(departmentId);
        } catch (EmployeeAddedException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/departments/employeesSortedOnDepartmwnts")
    public Map<Integer, List<Employee>> employeesWithSortedOfDepartments() {
        return employeeService.employeesWithSortedOfDepartments();
    }
}
