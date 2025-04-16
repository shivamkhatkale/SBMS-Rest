package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductEntity;

public interface IService {

	// 1. Create one Product
	Integer createProduct(ProductEntity p);

	// 2. Update Product
	void modifyProduct(ProductEntity p);

	// 3. Delete Product
	void deleteProduct(Integer id);

	// 4. All Product
	List<ProductEntity> getAllProduct();

	// 5. getOneProduct
	ProductEntity getOneProduct(Integer id);

}
