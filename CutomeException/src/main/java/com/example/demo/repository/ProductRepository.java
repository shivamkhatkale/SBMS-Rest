package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.student.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
