package com.example.demo.api.controller;

import com.example.demo.api.beans.PizzaBean;
import com.example.demo.api.beans.PizzaOrderBean;
import com.example.demo.api.service.PizzaOrderService;
import com.example.demo.api.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PizzaStoreController {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaOrderService pizzaOrderService;

    @RequestMapping(value = "/pizza/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PizzaBean>> getAllPizzaDetails() {
        List<PizzaBean> pizzaBeans = pizzaService.findAll();
        return new ResponseEntity<List<PizzaBean>>(pizzaBeans, HttpStatus.OK);
    }

    @RequestMapping(value = "/pizzaOrder/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PizzaOrderBean>> getAllOrderDetails() {
        List<PizzaOrderBean> pizzaOrderBeans = pizzaOrderService.findAll();
        return new ResponseEntity<List<PizzaOrderBean>>(pizzaOrderBeans, HttpStatus.OK);
    }

    @RequestMapping(value = "/pizza/getPizza/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PizzaBean> getPizzaDetailsById(@PathVariable("id") Long id) {
        PizzaBean pizzaBean = pizzaService.findOne(id);
        if (pizzaBean != null) {
            return new ResponseEntity<PizzaBean>(pizzaBean, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<PizzaBean>(pizzaBean, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/pizzaOrder/getOrder/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PizzaOrderBean> getPizzaOrderDetailsById(@PathVariable("id") Long id) {
        PizzaOrderBean pizzaOrderBean = pizzaOrderService.findOneByID(id);
        if (pizzaOrderBean != null) {
            return new ResponseEntity<PizzaOrderBean>(pizzaOrderBean, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<PizzaOrderBean>(pizzaOrderBean, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/pizza/addPizza", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> addNewPizza(@RequestBody PizzaBean pizzaBean) {
        Long id = pizzaService.addPizzaEntity(pizzaBean);
        return new ResponseEntity<String>("New Pizza added successfully id :- " + id, HttpStatus.OK);
    }

    @RequestMapping(value = "/pizzaOrder/addOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> addNewPizzaOrder(@RequestBody PizzaOrderBean pizzaOrderBean) {
        Long id = pizzaOrderService.addPizzaOrderEntity(pizzaOrderBean);
        return new ResponseEntity<String>("New Pizza order added successfully id :- " + id, HttpStatus.OK);
    }

    @RequestMapping(value = "/pizza/updatePizza", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PizzaBean> updatePizza(@RequestBody PizzaBean pizzaBean) {
        if (pizzaService.findOne(pizzaBean.getId()) == null) {
            PizzaBean pizza = null;
            return new ResponseEntity<PizzaBean>(pizza, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            PizzaBean pizza = pizzaService.updatePizzaEntity(pizzaBean);
            return new ResponseEntity<PizzaBean>(pizza, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/pizzaOrder/updatePizzaOrder", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PizzaOrderBean> updatePizzaOrder(@RequestBody PizzaOrderBean pizzaOrderBean) {
        if (pizzaOrderService.findOneByID(pizzaOrderBean.getId()) == null) {
            PizzaOrderBean pizzaOrder = null;
            return new ResponseEntity<PizzaOrderBean>(pizzaOrder, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            PizzaOrderBean pizzaOrder = pizzaOrderService.updatePizzaOrderEntity(pizzaOrderBean);
            return new ResponseEntity<PizzaOrderBean>(pizzaOrder, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/pizza/deletePizza/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> deletePizza(@PathVariable("id") Long id) {
        if (pizzaService.findOne(id) == null) {
            return new ResponseEntity<String>("Pizza not found with this id :- " + id, HttpStatus.NOT_FOUND);
        }
        else {
            Long res = pizzaService.deletePizzaEntity(id);
            return new ResponseEntity<String>("Pizza deleted successfully id :- " + res, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/pizzaOrder/deletePizzaOrder/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> deletePizzaOrder(@PathVariable("id") Long id) {
        if (pizzaOrderService.findOneByID(id) == null) {
            return new ResponseEntity<String>("Pizza order not found with this id :- " + id, HttpStatus.NOT_FOUND);
        }
        else {
            Long res = pizzaOrderService.deletePizzaOrderEntity(id);
            return new ResponseEntity<String>("Pizza order deleted successfully id :- " + res, HttpStatus.OK);
        }
    }

}
