package com.example.demo.api.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaBean {

    private Long id;

    private String name;

    private Double price;

    public PizzaBean() {
    }

    public PizzaBean(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
