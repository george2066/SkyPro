package com.example.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return service.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return service.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return service.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        if (num2 == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        return service.divide(num1, num2);
    }
}
