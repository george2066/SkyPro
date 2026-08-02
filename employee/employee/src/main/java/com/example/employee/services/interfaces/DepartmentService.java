package com.example.employee.services.interfaces;

import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartmentService {
    Department addDepartment(Integer departmentId);
    List<Employee> employeesDepartment(Integer departmentId);
    Integer sumSalaryDepartment(Integer departmentId);
    Integer maxSalaryDepartment(Integer departmentId);
    Integer minSalaryDepartment(Integer departmentId);
    Map<Department, List<Employee>> employeesSortedByDepartments();
    Set<Department> getDepartments();
}
