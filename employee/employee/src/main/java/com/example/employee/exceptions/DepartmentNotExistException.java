package com.example.employee.exceptions;

public class DepartmentNotExistException extends RuntimeException {
    public DepartmentNotExistException(String message) {
        super(message);
    }
}
