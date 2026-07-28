package com.example.employee.services;

import com.example.employee.Employee;
import com.example.employee.exceptions.EmployeeAlreadyAddedException;
import com.example.employee.exceptions.EmployeeNotFoundException;
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
    public Employee addEmployee(String firstname, String lastName, Integer salary, Integer department) {
        Employee employee = new Employee(firstname, lastName, salary, department);
        String fio = employee.getName() + " " + employee.getSurname();
        if (employees.containsKey(fio)) {
            throw new EmployeeAlreadyAddedException("Such employee already exists");
        }
        employees.put(fio, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstname, String lastName) {
        String fio = firstname + " " + lastName;
        Employee employee = employees.get(fio);
        if (employees.containsKey(fio)) {
            employees.remove(fio);
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmployee(String firstname, String lastName) {
        String fio = firstname + " " + lastName;
        if (employees.containsKey(fio)) {
            return employees.get(fio);
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Map<String, Employee> findAll() {
        return employees;
    }






    @Override
    public Integer maxSalaryOfDepartment(Integer id) {
        return employees.values().stream().map(
                Employee::getSalary
        ).max(Comparator.naturalOrder()).get();
    }

    @Override
    public Integer minSalaryOfDepartment(Integer id) {
        return employees.values().stream().map(
                Employee::getSalary
        ).min(Comparator.naturalOrder()).get();
    }

    @Override
    public List<Employee> employeesDepartment(Integer id) {
        return employees.values().stream().filter(
                e -> Objects.equals(e.getDepartment(), id)
        ).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> employeesWithSortedOfDepartments() {
        Map<Integer, List<Employee>> employeesSortedDepartments = new HashMap<>();
        List<Integer> departments = employees.values().stream().map(
                        Employee::getDepartment
                ).collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
        for (Integer department : departments) {
            employeesSortedDepartments.put(
                    department,
                    employees.values().stream()
                            .filter(e -> (e.getDepartment() == department))
                            .collect(Collectors.toList()));
        }
        return employeesSortedDepartments;
    }
}
