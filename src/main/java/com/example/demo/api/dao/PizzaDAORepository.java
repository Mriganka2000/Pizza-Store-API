package com.example.demo.api.dao;

import com.example.demo.api.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PizzaDAORepository extends JpaRepository<PizzaEntity, Long> {

    @Query("SELECT p FROM PizzaEntity p WHERE p.id = ?1")
    PizzaEntity findOneById(Long id);

}
