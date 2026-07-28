package com.example.employee.services;

import com.example.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstname, String lastName, Integer salary, Integer department);
    Employee removeEmployee(String firstname, String lastName);
    Employee findEmployee(String firstname, String lastName);
    Map<String, Employee> findAll();
    Integer maxSalaryOfDepartment(Integer id);
    Integer minSalaryOfDepartment(Integer id);
    List<Employee> employeesDepartment(Integer id);
    Map<Integer, List<Employee>> employeesWithSortedOfDepartments();
}
