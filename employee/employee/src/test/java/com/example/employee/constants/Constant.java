package com.example.employee.constants;

import com.example.employee.entities.Department;
import com.example.employee.entities.Employee;

public class Constant {
    public static final Department DEPARTMENT1 = new Department(1);
    public static final Department DEPARTMENT2 = new Department(2);
    public static final Department DEPARTMENT3 = new Department(3);
    public static final Department DEPARTMENT4 = new Department(4);

    public static final Employee EMPLOYEE_EXCEPTION_NAME = new Employee("Name1", "Surname", 20000, DEPARTMENT1, "7500201235");
    public static final Employee EMPLOYEE_NO_VALID_PASSPORT_10_SYMBOLS = new Employee("Name", "Surname", 30000, DEPARTMENT1, "75005201236");
    public static final Employee EMPLOYEE_PASSPORT_IS_NO_NUMERIC = new Employee("Name", "Surname", 40000, DEPARTMENT1, "750020L127");
    public static final Employee EMPLOYEE1 = new Employee("Name", "Surname", 10000, DEPARTMENT1, "7500201234");
    public static final Employee EMPLOYEE2 = new Employee("Name", "Surname", 20000, DEPARTMENT1, "7500201234");
    public static final Employee EMPLOYEE3 = new Employee("Name", "Surname", 30000, DEPARTMENT2, "7500201234");
    public static final Employee EMPLOYEE4 = new Employee("Name", "Surname", 40000, DEPARTMENT2, "7500201234");
    public static final Employee EMPLOYEE5 = new Employee("Name", "Surname", 50000, DEPARTMENT3, "7500201238");
    public static final Employee EMPLOYEE6 = new Employee("Name", "Surname", 60000, DEPARTMENT3, "7500201238");
    public static final Employee EMPLOYEE7 = new Employee("Name", "Surname", 70000, DEPARTMENT4, "7500201238");
    public static final Employee EMPLOYEE8 = new Employee("Name", "Surname", 80000, DEPARTMENT4, "7500201238");
    public static final Employee EMPLOYEE9 = new Employee("Name", "Surname", 90000, DEPARTMENT4, "7500201238");
}
