package com.example.demo.service;

import java.util.List;

import com.example.demo.student.Product;

public interface IProductService {

	// create
	Integer createProduct(Product product);

	// fetch one product
	Product getOneProduct(Integer id);

	// delete one product
	void deleteOneProduct(Integer id);

	// get all product
	List<String> getAllProduct();

	// update one product
	Product updateProduct();

	

}
