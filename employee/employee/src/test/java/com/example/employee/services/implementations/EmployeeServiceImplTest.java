package com.example.employee.services.implementations;

import com.example.employee.entities.Employee;
import com.example.employee.exceptions.EmployeeAddedException;
import com.example.employee.exceptions.EmployeeNotFoundException;
import com.example.employee.services.implementations.contans.ConstantException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static com.example.employee.constants.Constant.*;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Spy
    private HashMap<String, Employee> employeeMap;

    @InjectMocks
    private EmployeeServiceImpl service;

    @Test
    void addEmployeePositiveTest() {
        Employee employee = service.addEmployee(EMPLOYEE1);
        Assertions.assertEquals(EMPLOYEE1, employee);
    }

    @Test
    void addEmployeeNegativeTestByValidPassportIsNumeric() {
        EmployeeAddedException employeeAddedException = Assertions.assertThrows(
                EmployeeAddedException.class,
                () -> service.addEmployee(EMPLOYEE_PASSPORT_IS_NO_NUMERIC)
        );
        Assertions.assertEquals(
                ConstantException.NO_VALID_PASSPORT_NUMERIC,
                employeeAddedException.getMessage()
        );
    }

    @Test
    void addEmployeeNegativeTestByValidPassport10Symbols() {
        EmployeeAddedException employeeAddedException = Assertions.assertThrows(
                EmployeeAddedException.class,
                () -> service.addEmployee(EMPLOYEE_NO_VALID_PASSPORT_10_SYMBOLS)
        );
        Assertions.assertEquals(
                ConstantException.NO_VALID_PASSPORT_10_SYMBOLS,
                employeeAddedException.getMessage()
        );
    }

    @Test
    void addEmployeeNegativeTestByValidNameAndSurname() {
        EmployeeAddedException employeeAddedException = Assertions.assertThrows(
                EmployeeAddedException.class,
                () -> service.addEmployee(EMPLOYEE_EXCEPTION_NAME)
        );
        Assertions.assertEquals(
                ConstantException.EMPLOYEE_NAME_LATTERS_SYMBOLS,
                employeeAddedException.getMessage()
        );
    }

    @Test
    void addEmployeeNegativeTestByExistEmployee() {
        Employee employee1 = service.addEmployee(EMPLOYEE1);
        EmployeeAddedException employeeAddedException = Assertions.assertThrows(
                EmployeeAddedException.class,
                () -> service.addEmployee(EMPLOYEE1)
        );
        Assertions.assertEquals(
                ConstantException.EXIST_EMPLOYEE,
                employeeAddedException.getMessage()
        );
    }

    @Test
    void removeEmployeePositiveTest() {
        Employee employee = service.addEmployee(EMPLOYEE1);
        Employee result = service.removeEmployee(EMPLOYEE1.getPassport());
        Assertions.assertEquals(EMPLOYEE1, result);
        Mockito.verify(employeeMap).remove(EMPLOYEE1.getPassport());
    }

    @Test
    void removeEmployeeNegativeTestByValidPassportIsNumeric() {
        EmployeeAddedException employeeAddedException = Assertions.assertThrows(
                EmployeeAddedException.class,
                () -> service.removeEmployee(EMPLOYEE_PASSPORT_IS_NO_NUMERIC.getPassport())
        );
        Assertions.assertEquals(
                ConstantException.NO_VALID_PASSPORT_NUMERIC,
                employeeAddedException.getMessage()
        );
    }

    @Test
    void removeEmployeeNegativeTestByNotExistEmployee() {
        EmployeeNotFoundException employeeNotFoundException = Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> service.removeEmployee(EMPLOYEE1.getPassport())
        );
        Assertions.assertEquals(
                ConstantException.EMPLOYEE_NOT_FOUND,
                employeeNotFoundException.getMessage()
        );
    }

    @Test
    void findEmployeePositiveTest() {
        Employee employee = service.addEmployee(EMPLOYEE1);
        Employee employeeTarget = service.findEmployee(EMPLOYEE1.getPassport());
        Assertions.assertNotNull(employeeTarget);
        Assertions.assertEquals(EMPLOYEE1, employeeTarget);
    }

    @Test
    void findEmployeeNegativeTestByNotExistEmployee() {
        EmployeeNotFoundException employeeNotFoundException = Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> service.findEmployee(EMPLOYEE1.getPassport())
        );
        Assertions.assertEquals(
                ConstantException.EMPLOYEE_NOT_FOUND,
                employeeNotFoundException.getMessage()
        );
    }

    @Test
    void findAllTest() {
        Map<String, Employee> employeeMap1 = new HashMap<>();
        employeeMap1.put(EMPLOYEE1.getPassport(), EMPLOYEE1);
        service.addEmployee(EMPLOYEE1);
        Assertions.assertEquals(employeeMap1, employeeMap);
    }
}