package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface IService {

	Integer saveProduct(Product product);

	void deleteProduct(Integer id);

	Product getOneProduct(Integer id);
	
	List<Product> fetchAll();
	
	void updateProduct(Product product);

}
