package com.example.employee.controllers;

import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;
import com.example.employee.exceptions.DepartmentExistException;
import com.example.employee.exceptions.DepartmentNotExistException;
import com.example.employee.services.interfaces.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public String addDepartment(
            @PathVariable("id") Integer departmentId
    ) {
        try {
            Department department = service.addDepartment(departmentId);
            return "Отдел " + department.getId() + " добавлен в список: \n" + service.getDepartments();
        } catch (DepartmentExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/{id}/employees")
    public List<Employee> employeesDepartment(
            @PathVariable("id") Integer departmentId
    ) {
        try {
            return service.employeesDepartment(departmentId);
        } catch (DepartmentNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/{id}/salary/sum")
    public String  sumSalaryDepartment(
            @PathVariable("id") Integer departmentId
    ) {
        try {
            Integer sumSalary = service.sumSalaryDepartment(departmentId);
            return "Сумма зарплат отдела №" + departmentId + " состяавляет " + sumSalary + " рублей.";
        } catch (DepartmentNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/{id}/salary/max")
    public String maxSalaryDepartment(
            @PathVariable("id") Integer departmentId
    ) {
        try {
            Integer maxSalary = service.maxSalaryDepartment(departmentId);
            return "Максимальная зарплата отдела №" + departmentId + " состяавляет " + maxSalary + " рублей.";
        } catch (DepartmentNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }
    }

    @GetMapping("/{id}/salary/min")
    public String minSalaryDepartment(
            @PathVariable("id") Integer departmentId
    ) {
        try {
            Integer minSalary = service.minSalaryDepartment(departmentId);
            return "Минимальная зарплата отдела №" + departmentId + " состяавляет " + minSalary + " рублей.";
        } catch (DepartmentNotExistException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data is not valid: " + e.getMessage(), e
            );
        }

    }
    @GetMapping("/employees")
    public Map<Department, List<Employee>> employeesSortedByDepartments() {
        return service.employeesSortedByDepartments();
    }
}
