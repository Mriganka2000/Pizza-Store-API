package com.example.demo.api.service;

import com.example.demo.api.beans.PizzaOrderBean;
import com.example.demo.api.dao.PizzaOrderDAOWrapper;
import com.example.demo.api.entity.PizzaOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {

    @Autowired
    private PizzaOrderDAOWrapper pizzaOrderDAOWrapper;

    @Override
    public List<PizzaOrderBean> findAll() {
        return pizzaOrderDAOWrapper.findAll();
    }

    @Override
    public PizzaOrderBean findOneByID(Long id) {
        return pizzaOrderDAOWrapper.findOneByID(id);
    }

    @Override
    public Long addPizzaOrderEntity(PizzaOrderBean pizzaOrderBean) {
        return pizzaOrderDAOWrapper.addPizzaOrderEntity(pizzaOrderBean);
    }

    @Override
    public PizzaOrderBean updatePizzaOrderEntity(PizzaOrderBean pizzaOrderBean) {
        return pizzaOrderDAOWrapper.updatePizzaOrderEntity(pizzaOrderBean);
    }

    @Override
    public Long deletePizzaOrderEntity(Long id) {
        return pizzaOrderDAOWrapper.deletePizzaOrderEntity(id);
    }

}
