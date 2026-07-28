package com.example.employee;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private Integer salary;
    private Integer department;
    private String passport;

    public Employee(String name, String surname, Integer salary, Integer department, String passport) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public String getPassport(){
        return passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(salary, employee.salary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
