package com.example.employee.services.implementations;

import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;
import com.example.employee.exceptions.EmployeeAddedException;
import com.example.employee.exceptions.EmployeeNotFoundException;
import com.example.employee.services.implementations.contans.ConstantException;
import com.example.employee.services.interfaces.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl(HashMap<String, Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        String fio = employee.getName() + employee.getSurname();
        if (employees.containsKey(employee.getPassport())) {
            throw new EmployeeAddedException(ConstantException.EXIST_EMPLOYEE);
        } else if (employee.getPassport().length() != 10) {
            throw new EmployeeAddedException(ConstantException.NO_VALID_PASSPORT_10_SYMBOLS);
        } else if (!StringUtils.isAlpha(fio)) {
            throw new EmployeeAddedException(ConstantException.EMPLOYEE_NAME_LATTERS_SYMBOLS);
        } else if (!StringUtils.isNumeric(employee.getPassport())) {
            throw new EmployeeAddedException(ConstantException.NO_VALID_PASSPORT_NUMERIC);
        }
        employees.put(employee.getPassport(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String passport) {
        Employee employee = employees.get(passport);
        if (employees.containsKey(passport)) {
            employees.remove(passport);
            return employee;
        } else if (!StringUtils.isNumeric(passport)) {
            throw new EmployeeAddedException(ConstantException.NO_VALID_PASSPORT_NUMERIC);
        }
        throw new EmployeeNotFoundException(ConstantException.EMPLOYEE_NOT_FOUND);
    }

    @Override
    public Employee findEmployee(String passport) {
        if (employees.containsKey(passport)) {
            return employees.get(passport);
        }
        if (!StringUtils.isNumeric(passport)) {
            throw new EmployeeAddedException(ConstantException.NO_VALID_PASSPORT_NUMERIC);
        }
        throw new EmployeeNotFoundException(ConstantException.EMPLOYEE_NOT_FOUND);
    }

    @Override
    public Map<String, Employee> findAll() {
        return employees;
    }
}
