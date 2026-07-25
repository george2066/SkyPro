package com.example.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public String plus(Integer num1, Integer num2) {
        int result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }

    @Override
    public String minus(Integer num1, Integer num2) {
        int result = num1 - num2;
        return num1 + " - " + num2 + " = " + result;
    }

    @Override
    public String multiply(Integer num1, Integer num2) {
        int result = num1 * num2;
        return num1 + " x " + num2 + " = " + result;
    }

    @Override
    public String divide(Integer num1, Integer num2) {
        int result = num1 / num2;
        return num1 + " / " + num2 + " = " + result;
    }
}
