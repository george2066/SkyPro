package com.example.store.controllers;

import com.example.store.interfaces.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class BasketController {
    @Autowired
    private BasketService service;

    @GetMapping("/add")
    public String addProduct(@RequestParam("id") Integer products) {
        return service.addInBasket(products);
    }

    @GetMapping("/get")
    public String getBasket() {
        return service.getBasket();
    }

    @GetMapping("/addAll")
    public String addAllProducts(@RequestParam("ids") List<Integer> products) {
        return service.addListInBasket(products);
    }
}
