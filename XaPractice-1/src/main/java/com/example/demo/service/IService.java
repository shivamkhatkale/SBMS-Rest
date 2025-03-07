package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductEntity;

public interface IService {

	Integer saveProduct(ProductEntity productEntity);

	void deleteProduct(Integer id);

	ProductEntity getOneProduct(Integer id);

	List<ProductEntity> fetchAll();

	void updateProduct(ProductEntity productEntity);

}
