package com.example.employee;

import com.example.employee.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("surname") String surname) {
        return employeeService.addEmployee(name, surname);
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
    public List<Object> findAll() {
        return employeeService.findAll();
    }
}
