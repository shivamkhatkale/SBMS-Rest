package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductEntity;

public interface IService {

	// create one product
	Integer createOneProduct(ProductEntity p);

	// getoneProduct
	ProductEntity getOneProduct(Integer id);

	// deleteOneProduct
	void deleteOneProduct(Integer id);

	// getAllList
	List<ProductEntity> getAllList();

	// update one product
	ProductEntity updateProduct(ProductEntity p);



}
