package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductEntity;

//@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

	
	
}
