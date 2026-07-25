package com.example.employee.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException (String message) {
        super(message);
    }
}
