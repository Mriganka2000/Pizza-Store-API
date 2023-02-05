package com.example.demo.api.dao;

import com.example.demo.api.beans.PizzaOrderBean;
import com.example.demo.api.entity.PizzaOrderEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PizzaOrderDAOWrapper {

    @Autowired
    private PizzaOrderDAORepository pizzaOrderDAORepository;

    public List<PizzaOrderBean> findAll() {
        Iterable<PizzaOrderEntity> pizzaOrderEntities = pizzaOrderDAORepository.findAll();
        List<PizzaOrderBean> pizzaOrderBeans = new LinkedList<>();

        pizzaOrderEntities.forEach(pizzaOrderEntity -> {
            PizzaOrderBean pizzaOrderBean = new PizzaOrderBean();
            BeanUtils.copyProperties(pizzaOrderEntity, pizzaOrderBean);
            pizzaOrderBeans.add(pizzaOrderBean);
        });

        return pizzaOrderBeans;
    }

    public PizzaOrderBean findOneByID(Long id) {
        PizzaOrderEntity pizzaOrderEntity = pizzaOrderDAORepository.findOneById(id);
        PizzaOrderBean pizzaOrderBean = new PizzaOrderBean();

        BeanUtils.copyProperties(pizzaOrderEntity, pizzaOrderBean);

        return pizzaOrderBean;
    }

    public Long addPizzaOrderEntity(PizzaOrderBean pizzaOrderBean) {
        PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();

        BeanUtils.copyProperties(pizzaOrderBean, pizzaOrderEntity);
        PizzaOrderEntity pizzaOrder = pizzaOrderDAORepository.save(pizzaOrderEntity);

        return pizzaOrder.getId();
    }

    public PizzaOrderBean updatePizzaOrderEntity(PizzaOrderBean pizzaOrderBean) {
        PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();
        BeanUtils.copyProperties(pizzaOrderBean, pizzaOrderEntity);

        PizzaOrderEntity pizzaOrder = pizzaOrderDAORepository.save(pizzaOrderEntity);
        PizzaOrderBean pizzaOrderBeanUpdated = new PizzaOrderBean();

        BeanUtils.copyProperties(pizzaOrder, pizzaOrderBeanUpdated);

        return pizzaOrderBeanUpdated;
    }

    public Long deletePizzaOrderEntity(Long id) {
        PizzaOrderEntity pizzaOrderEntity = pizzaOrderDAORepository.findOneById(id);
        pizzaOrderDAORepository.delete(pizzaOrderEntity);
        return id;
    }

}
