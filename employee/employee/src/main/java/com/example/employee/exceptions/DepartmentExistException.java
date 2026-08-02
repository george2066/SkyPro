package com.example.employee.exceptions;

public class DepartmentExistException extends RuntimeException {
    public DepartmentExistException(String message) {
        super(message);
    }
}
