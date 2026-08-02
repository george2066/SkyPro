package com.example.employee.services.implementations;

import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;
import com.example.employee.exceptions.DepartmentExistException;
import com.example.employee.exceptions.DepartmentNotExistException;
import com.example.employee.services.implementations.contans.ConstantException;
import com.example.employee.services.interfaces.DepartmentService;
import com.example.employee.services.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;
    private final Set<Department> departments;

    public DepartmentServiceImpl(EmployeeService employeeService, HashSet<Department> departments) {
        this.employeeService = employeeService;
        this.departments = departments;
    }

    @Override
    public Department addDepartment(Integer departmentId) {
        Department department = new Department(departmentId);
        if (departments.contains(department)) {
            throw new DepartmentExistException(ConstantException.EXIST_DEPARTMENT);
        }
        departments.add(department);
        return department;
    }

    @Override
    public List<Employee> employeesDepartment(Integer departmentId) {
        Department department = new Department(departmentId);
        if (!departments.contains(department)) {
            throw new DepartmentNotExistException(ConstantException.DEPARTMENT_NOT_FOUND);
        }
        return employeeService.findAll().values().stream()
                .filter(e -> (Objects.equals(e.getDepartment().getId(), departmentId)))
                .collect(Collectors.toList());
    }

    @Override
    public Integer sumSalaryDepartment(Integer departmentId) {
        Department department = new Department(departmentId);
        if (!departments.contains(department)) {
            throw new DepartmentNotExistException(ConstantException.DEPARTMENT_NOT_FOUND);
        }
        List<Employee> employees = employeesDepartment(departmentId);
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    @Override
    public Integer maxSalaryDepartment(Integer departmentId) {
        Department department = new Department(departmentId);
        if (!departments.contains(department)) {
            throw new DepartmentNotExistException(ConstantException.DEPARTMENT_NOT_FOUND);
        }
        List<Employee> employees = employeesDepartment(departmentId);
        return employees.stream().filter(e -> Objects.equals(e.getDepartment(), department)).map(
                Employee::getSalary
        ).max(Comparator.naturalOrder()).orElse(-1);
    }

    @Override
    public Integer minSalaryDepartment(Integer departmentId) {
        if (!departments.contains(departmentId)) {
            throw new DepartmentNotExistException(ConstantException.DEPARTMENT_NOT_FOUND);
        }
        List<Employee> employees = employeesDepartment(departmentId);
        return employees.stream().filter(e -> Objects.equals(e.getDepartment(), departmentId)).map(
                Employee::getSalary
        ).min(Comparator.naturalOrder()).get();
    }

    @Override
    public Map<Department, List<Employee>> employeesSortedByDepartments() {
        Map<String, Employee> employees = employeeService.findAll();
        Map<Department, List<Employee>> employeesSortedDepartments = new HashMap<>();
        List<Department> departmentList = new ArrayList<>(departments);
        for (Department department : departmentList) {
            employeesSortedDepartments.put(
                    department,
                    employees.values().stream()
                            .filter(e -> (Objects.equals(e.getDepartment().getId(), department)))
                            .collect(Collectors.toList()));
        }
        return employeesSortedDepartments;
    }

    @Override
    public Set<Department> getDepartments() {
        return departments;
    }
}
