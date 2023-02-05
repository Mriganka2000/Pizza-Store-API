package com.example.demo.api.dao;

import com.example.demo.api.entity.PizzaOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PizzaOrderDAORepository extends JpaRepository<PizzaOrderEntity, Long> {

    @Query("SELECT p FROM PizzaOrderEntity p WHERE p.id = ?1")
    PizzaOrderEntity findOneById(Long id);

}
