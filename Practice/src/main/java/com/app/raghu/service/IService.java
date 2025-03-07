package com.app.raghu.service;

import java.util.List;

import com.app.raghu.entity.Product;

public interface IService {

	Integer createOneProduct(Product p);

	void deleteProduct(Integer id);

	Product getOneProduct(Integer id);

	void UpdateProduct(Product p);

	List<Product> getAllProduct();

}
