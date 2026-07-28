package com.example.employee.services;

import com.example.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstname, String lastName, Integer salary, Integer department, String passport);
    Employee removeEmployee(String passport);
    Employee findEmployee(String passport);
    Map<String, Employee> findAll();
    Integer maxSalaryOfDepartment(Integer id);
    Integer minSalaryOfDepartment(Integer id);
    List<Employee> employeesDepartment(Integer id);
    Map<Integer, List<Employee>> employeesWithSortedOfDepartments();
}
