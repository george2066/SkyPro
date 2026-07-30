package com.example.store.services;

import com.example.store.interfaces.BasketService;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@SessionScope
public class BasketServiceImpl implements BasketService {
    private List<Integer> products;
    private final ObjectMapper objectMapper;

    public BasketServiceImpl(List<Integer> products, ObjectMapper objectMapper) {
        this.products = products;
        this.objectMapper = objectMapper;
    }

    @Override
    public String addInBasket(Integer product) {
        products.add(product);
        return objectMapper.writeValueAsString(products);
    }

    @Override
    public String getBasket() {
        return objectMapper.writeValueAsString(products);
    }

    @Override
    public String addListInBasket(List<Integer> productsList) {
        products.addAll(productsList);
        return objectMapper.writeValueAsString(productsList);
    }

    @PostConstruct
    public void setup() {
        System.out.println("BasketServiceImpl is created");
    }
}
