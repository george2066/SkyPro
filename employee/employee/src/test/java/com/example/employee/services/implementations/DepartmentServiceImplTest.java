package com.example.employee.services.implementations;

import com.example.employee.constants.Constant;
import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;
import com.example.employee.exceptions.DepartmentExistException;
import com.example.employee.exceptions.DepartmentNotExistException;
import com.example.employee.exceptions.EmployeeAddedException;
import com.example.employee.services.implementations.contans.ConstantException;
import com.example.employee.services.interfaces.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.employee.constants.Constant.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Spy
    private HashSet<Department> departments;

    @Spy
    private HashMap<String, Employee> employeeMap;

    @Mock
    private EmployeeServiceImpl serviceEmployee;

    @InjectMocks
    private DepartmentServiceImpl serviceDepartment;

    @BeforeEach
    void setup() {
        departments.add(DEPARTMENT2);
        departments.add(DEPARTMENT3);
        departments.add(DEPARTMENT4);

        serviceEmployee.addEmployee(EMPLOYEE1);
        serviceEmployee.addEmployee(EMPLOYEE2);
        serviceEmployee.addEmployee(EMPLOYEE3);
        serviceEmployee.addEmployee(EMPLOYEE4);
        serviceEmployee.addEmployee(EMPLOYEE5);
        serviceEmployee.addEmployee(EMPLOYEE6);
        serviceEmployee.addEmployee(EMPLOYEE7);
        serviceEmployee.addEmployee(EMPLOYEE8);
        serviceEmployee.addEmployee(EMPLOYEE9);
    }

    @Test
    void addDepartmentPositiveTest() {
        Department department = serviceDepartment.addDepartment(1);
        Assertions.assertEquals(DEPARTMENT1, department);
    }

    @Test
    void addDepartmentNegativeTest() {
        DepartmentExistException departmentExistException = Assertions.assertThrows(
                DepartmentExistException.class,
                () -> serviceDepartment.addDepartment(DEPARTMENT2.getId())
        );
        Assertions.assertEquals(
                ConstantException.EXIST_DEPARTMENT,
                departmentExistException.getMessage()
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamForTests")
    void employeesDepartmentPositiveTest(Integer departmentId) {
        Map<String, Employee> employees = new HashMap();
        employees.put(EMPLOYEE1.getPassport(), EMPLOYEE1);
        employees.put(EMPLOYEE2.getPassport(), EMPLOYEE2);
        employees.put(EMPLOYEE3.getPassport(), EMPLOYEE3);
        employees.put(EMPLOYEE4.getPassport(), EMPLOYEE4);
        employees.put(EMPLOYEE5.getPassport(), EMPLOYEE5);
        employees.put(EMPLOYEE6.getPassport(), EMPLOYEE6);
        employees.put(EMPLOYEE7.getPassport(), EMPLOYEE7);
        employees.put(EMPLOYEE8.getPassport(), EMPLOYEE8);
        employees.put(EMPLOYEE9.getPassport(), EMPLOYEE9);
        List<Employee> employeeList = employees.values().stream().filter(
                e -> (Objects.equals(e.getDepartment(), departmentId))).collect(Collectors.toList());
        Assertions.assertEquals(serviceDepartment.employeesDepartment(departmentId), employeeList);
    }

    @Test
    void employeesDepartmentNegativeTest() {
        DepartmentNotExistException departmentNotExistException = Assertions.assertThrows(
                DepartmentNotExistException.class,
                () -> serviceDepartment.employeesDepartment(99)
        );
        Assertions.assertEquals(
                ConstantException.DEPARTMENT_NOT_FOUND,
                departmentNotExistException.getMessage()
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamForTests")
    void sumSalaryDepartmentPositiveTest(Integer departmentId) {
        List<Employee> employees = serviceDepartment.employeesDepartment(departmentId);
        Integer expected = employees.stream().mapToInt(Employee::getSalary).sum();
        Integer actual = serviceDepartment.sumSalaryDepartment(departmentId);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sumSalaryNegativeTest() {
        DepartmentNotExistException departmentNotExistException = Assertions.assertThrows(
                DepartmentNotExistException.class,
                () -> serviceDepartment.sumSalaryDepartment(99)
        );
        Assertions.assertEquals(
                ConstantException.DEPARTMENT_NOT_FOUND,
                departmentNotExistException.getMessage()
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamForTests")
    void maxSalaryDepartmentPositiveTest(Integer departmentId) {
        List<Employee> employees = serviceDepartment.employeesDepartment(departmentId);
        Integer expected = employees.stream().mapToInt(Employee::getSalary).max().orElse(-1);;
        Integer actual = serviceDepartment.maxSalaryDepartment(departmentId);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void maxSalaryDepartmentNegativeTest() {
        DepartmentNotExistException departmentNotExistException = Assertions.assertThrows(
                DepartmentNotExistException.class,
                () -> serviceDepartment.maxSalaryDepartment(99)
        );
        Assertions.assertEquals(
                ConstantException.DEPARTMENT_NOT_FOUND,
                departmentNotExistException.getMessage()
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamForTests")
    void minSalaryDepartmentPositiveTest(Integer departmentId) {
        List<Employee> employees = serviceDepartment.employeesDepartment(departmentId);
        Integer expected = employees.stream().mapToInt(Employee::getSalary).max().orElse(-1);;
        Integer actual = serviceDepartment.maxSalaryDepartment(departmentId);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minSalaryDepartmentNegativeTest() {
        DepartmentNotExistException departmentNotExistException = Assertions.assertThrows(
                DepartmentNotExistException.class,
                () -> serviceDepartment.minSalaryDepartment(99)
        );
        Assertions.assertEquals(
                ConstantException.DEPARTMENT_NOT_FOUND,
                departmentNotExistException.getMessage()
        );
    }

    @Test
    void employeesSortedByDepartments() {
        List<Department> departmentList = new ArrayList<>(departments);
        Map<String, Employee> employees = serviceEmployee.findAll();
        Map<Department, List<Employee>> employeesSortedDepartments = new HashMap<>();

        for (Department department : departmentList) {
            employeesSortedDepartments.put(
                    department,
                    employees.values().stream()
                            .filter(e -> (Objects.equals(e.getDepartment().getId(), department)))
                            .collect(Collectors.toList())
            );
        }

        Assertions.assertEquals(employeesSortedDepartments, serviceDepartment.employeesSortedByDepartments());
    }

    @Test
    void getDepartments() {
        Assertions.assertEquals(departments, serviceDepartment.getDepartments());
    }

    private static Stream<Arguments> provideParamForTests() {
        return Stream.of(
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4)
        );
    }
}