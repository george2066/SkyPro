package ru.hogwards.school.school.exceptions;

import org.apache.coyote.BadRequestException;

public class BadRequestNullFieldsException extends RuntimeException {
    public BadRequestNullFieldsException(String message) {
        super(message);
    }
}
