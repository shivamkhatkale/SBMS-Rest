package com.raghu.app.service;

import java.util.List;

import com.raghu.app.entity.Product;

public interface IProductService {

	Integer createProduct(Product product);

	Product getOneProduct(Integer p);

	void deleteProduct(Integer p);

	List<Product> getAllProduct();

	Integer modifyProduct(Product product);

}
