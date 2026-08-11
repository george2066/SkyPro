package ru.hogwards.school.school.exceptions;

public class NotFoundStudentException extends RuntimeException {
    public NotFoundStudentException(String message) {
        super(message);
    }
}
