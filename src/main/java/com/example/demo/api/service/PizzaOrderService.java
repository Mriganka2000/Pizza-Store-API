package com.example.demo.api.service;

import com.example.demo.api.beans.PizzaOrderBean;
import com.example.demo.api.entity.PizzaOrderEntity;

import java.util.List;

public interface PizzaOrderService {

    List<PizzaOrderBean> findAll();

    PizzaOrderBean findOneByID(Long id);

    Long addPizzaOrderEntity(PizzaOrderBean pizzaOrderBean);

    PizzaOrderBean updatePizzaOrderEntity(PizzaOrderBean pizzaOrderBean);

    Long deletePizzaOrderEntity(Long id);

}
