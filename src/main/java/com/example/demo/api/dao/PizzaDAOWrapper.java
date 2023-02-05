package com.example.demo.api.dao;

import com.example.demo.api.beans.PizzaBean;
import com.example.demo.api.entity.PizzaEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PizzaDAOWrapper {

    @Autowired
    private PizzaDAORepository pizzaDAORepository;

    public List<PizzaBean> findAll() {
        Iterable<PizzaEntity> pizzaEntities = pizzaDAORepository.findAll();
        List<PizzaBean> pizzaBeans = new LinkedList<>();

        pizzaEntities.forEach(pizza -> {
            PizzaBean pizzaBean = new PizzaBean();
            BeanUtils.copyProperties(pizza, pizzaBean);
            pizzaBeans.add(pizzaBean);
        });

        return pizzaBeans;
    }

    public PizzaBean findOne(Long id) {
        PizzaEntity pizzaEntity = pizzaDAORepository.findOneById(id);
        PizzaBean pizzaBean = new PizzaBean();
        BeanUtils.copyProperties(pizzaEntity, pizzaBean);
        return pizzaBean;
    }

    public Long addPizzaEntity(PizzaBean pizzaBean) {
        PizzaEntity pizzaEntity = new PizzaEntity();

        BeanUtils.copyProperties(pizzaBean, pizzaEntity);
        PizzaEntity pizza = pizzaDAORepository.save(pizzaEntity);

        return pizza.getId();
    }

    public PizzaBean updatePizzaEntity(PizzaBean pizzaBean) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        BeanUtils.copyProperties(pizzaBean, pizzaEntity);

        PizzaEntity pizza = pizzaDAORepository.save(pizzaEntity);
        PizzaBean pizzaBeanUpdated = new PizzaBean();

        BeanUtils.copyProperties(pizza, pizzaBeanUpdated);

        return pizzaBeanUpdated;
    }

    public Long deletePizzaEntity(Long id) {
        PizzaEntity pizzaEntity = pizzaDAORepository.findOneById(id);
        pizzaDAORepository.delete(pizzaEntity);
        return id;
    }

}
