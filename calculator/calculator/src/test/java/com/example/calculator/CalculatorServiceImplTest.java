package com.example.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private CalculatorService service = new CalculatorServiceImpl();

    @Test
    void plus() {
        String expected = "2 + 2 = 4";
        String actual = service.plus(2, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minus() {
        String expected = "2 - 2 = 0";
        String actual = service.minus(2, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        String expected = "2 x 2 = 4";
        String actual = service.multiply(2, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void dividePositive() {
        String expected = "2 / 2 = 1.0";
        String actual = service.divide(2, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divideNegative() {
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> service.divide(2, 0)
        );
    }
}