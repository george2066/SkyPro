package com.example.employee.services;

import com.example.employee.Employee;
import com.example.employee.exceptions.DepartmentNotExistException;
import com.example.employee.exceptions.EmployeeAddedException;
import com.example.employee.exceptions.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl(HashMap<String, Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String firstname, String lastName, Integer salary, Integer department, String passport) {
        String fio = firstname + lastName;
        if (employees.containsKey(passport)) {
            System.out.println(1);
            throw new EmployeeAddedException("Such employee already exists");
        } else if (passport.length() != 10) {
            throw new EmployeeAddedException("Passport must be =10 symbols");
        } else if (!StringUtils.isAlpha(fio)) {
            throw new EmployeeAddedException("Name and surname mast have only latters-symbols");
        } else if (!StringUtils.isNumeric(passport)) {
            throw new EmployeeAddedException("Passport mast have only numeric");
        }
        Employee employee = new Employee(firstname, lastName, salary, department, passport);
        employees.put(passport, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String passport) {
        Employee employee = employees.get(passport);
        if (employees.containsKey(passport)) {
            employees.remove(passport);
            return employee;
        } else if (StringUtils.isNumeric(passport)) {
            throw new EmployeeAddedException("Passport mast have only numeric");
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmployee(String passport) {
        if (employees.containsKey(passport)) {
            return employees.get(passport);
        } if (StringUtils.isNumeric(passport)) {
            throw new EmployeeAddedException("Passport mast have only numeric");
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Map<String, Employee> findAll() {
        return employees;
    }

    @Override
    public Integer maxSalaryOfDepartment(Integer id) {
        Integer maxDepartments = departments().size();
        if (id > maxDepartments) {
            throw new DepartmentNotExistException("Неверный номер отдела");
        }
        return employees.values().stream().filter(e -> Objects.equals(e.getDepartment(), id)).map(
                Employee::getSalary
        ).max(Comparator.naturalOrder()).get();
    }

    @Override
    public Integer minSalaryOfDepartment(Integer id) {
        Integer maxDepartments = departments().size();
        if (id > maxDepartments) {
            throw new DepartmentNotExistException("Неверный номер отдела");
        }
        return employees.values().stream().filter(e -> Objects.equals(e.getDepartment(), id)).map(
                Employee::getSalary
        ).min(Comparator.naturalOrder()).get();
    }

    @Override
    public List<Employee> employeesDepartment(Integer id) {
        Integer maxDepartments = departments().size();
        if (id > maxDepartments) {
            throw new DepartmentNotExistException("Неверный номер отдела");
        }
        return employees.values().stream().filter(
                e -> Objects.equals(e.getDepartment(), id)
        ).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> employeesWithSortedOfDepartments() {
        Map<Integer, List<Employee>> employeesSortedDepartments = new HashMap<>();
        List<Integer> departments = departments();
        for (Integer department : departments) {
            employeesSortedDepartments.put(
                    department,
                    employees.values().stream()
                            .filter(e -> (e.getDepartment() == department))
                            .collect(Collectors.toList()));
        }
        return employeesSortedDepartments;
    }

    private List<Integer> departments() {
        return employees.values().stream().map(
                        Employee::getDepartment
                ).collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
    }
}
