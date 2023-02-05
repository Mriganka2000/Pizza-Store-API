package com.example.demo.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
@Getter
@Setter
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id", nullable = false)
    private Long id;

    @Column(name = "pizza_name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    public PizzaEntity() {
    }

    public PizzaEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }

}
