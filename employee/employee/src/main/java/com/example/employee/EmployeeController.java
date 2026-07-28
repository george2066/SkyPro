package com.example.employee;

import com.example.employee.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam("department") Integer department
    ) {
        return employeeService.addEmployee(name, surname, salary, department);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname) {
        return employeeService.removeEmployee(name, surname);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("name") String name,
                                 @RequestParam ("surname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping("/findAll")
    public Map<String, Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/departments/max-salary")
    public Integer maxSalaryOfDepartment(
            @RequestParam("departmentId") Integer departmentId
    ) {
        return employeeService.maxSalaryOfDepartment(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Integer minSalaryOfDepartment(
            @RequestParam("departmentId") Integer departmentId
    ) {
        return employeeService.minSalaryOfDepartment(departmentId);
    }

    @GetMapping("/departments/employees")
    public List<Employee> employeesDepartment(
            @RequestParam("departmentId") Integer departmentId
    ) {
        return employeeService.employeesDepartment(departmentId);
    }

    @GetMapping("/departments/employeesSortedOnDepartmwnts")
    public Map<Integer, List<Employee>> employeesWithSortedOfDepartments() {
        return employeeService.employeesWithSortedOfDepartments();
    }
}
