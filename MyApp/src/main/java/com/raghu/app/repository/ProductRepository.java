package com.raghu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
