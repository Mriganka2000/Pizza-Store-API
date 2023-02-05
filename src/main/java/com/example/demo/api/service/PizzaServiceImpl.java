package com.example.demo.api.service;

import com.example.demo.api.beans.PizzaBean;
import com.example.demo.api.dao.PizzaDAOWrapper;
import com.example.demo.api.entity.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaDAOWrapper pizzaDAOWrapper;

    @Override
    public List<PizzaBean> findAll() {
        return pizzaDAOWrapper.findAll();
    }

    @Override
    public PizzaBean findOne(Long id) {
        return pizzaDAOWrapper.findOne(id);
    }

    @Override
    public Long addPizzaEntity(PizzaBean pizzaBean) {
        return pizzaDAOWrapper.addPizzaEntity(pizzaBean);
    }

    @Override
    public PizzaBean updatePizzaEntity(PizzaBean pizzaBean) {
        return pizzaDAOWrapper.updatePizzaEntity(pizzaBean);
    }

    @Override
    public Long deletePizzaEntity(Long id) {
        return pizzaDAOWrapper.deletePizzaEntity(id);
    }

}
