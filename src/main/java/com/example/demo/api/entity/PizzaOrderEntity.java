package com.example.demo.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
public class PizzaOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "number_of_pieces_ordered")
    private Integer numberOfPiecesOrdered;

    @Column(name = "bill")
    private Double bill;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "pizza_id")
    private PizzaEntity pizza;

    public PizzaOrderEntity() {
    }

    public PizzaOrderEntity(String customerName, String contractNumber, Integer numberOfPiecesOrdered, Double bill, PizzaEntity pizza) {
        this.customerName = customerName;
        this.contractNumber = contractNumber;
        this.numberOfPiecesOrdered = numberOfPiecesOrdered;
        this.bill = bill;
        this.pizza = pizza;
    }

}
