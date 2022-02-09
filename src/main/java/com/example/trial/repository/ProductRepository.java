package com.example.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trial.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
