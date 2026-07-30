package com.example.store.interfaces;

import java.util.List;

public interface BasketService {
    String addInBasket(Integer product);
    String getBasket();

    String addListInBasket(List<Integer> products);
}
