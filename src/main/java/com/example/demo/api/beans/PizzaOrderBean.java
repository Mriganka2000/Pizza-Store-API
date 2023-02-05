package com.example.demo.api.beans;

import com.example.demo.api.entity.PizzaEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaOrderBean {

    private Long id;

    private String customerName;

    private String contractNumber;

    private Integer numberOfPiecesOrdered;

    private Double bill;

    private PizzaEntity pizza;

}
