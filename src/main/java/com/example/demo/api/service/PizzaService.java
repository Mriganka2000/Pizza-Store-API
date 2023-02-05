package com.example.demo.api.service;

import com.example.demo.api.beans.PizzaBean;
import com.example.demo.api.entity.PizzaEntity;

import java.util.List;

public interface PizzaService {

    List<PizzaBean> findAll();

    PizzaBean findOne(Long id);

    Long addPizzaEntity(PizzaBean pizzaBean);

    PizzaBean updatePizzaEntity(PizzaBean pizzaBean);

    Long deletePizzaEntity(Long id);

}
