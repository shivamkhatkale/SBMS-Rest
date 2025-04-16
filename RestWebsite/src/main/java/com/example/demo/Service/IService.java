package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Product;

public interface IService {
	
	// 1. Create a Product
	Integer createProduct(Product p);
	
	// 2. Modify a product
	void modifyProduct(Product p);
	
	// 3. Delete a Product
	void deleteProduct(Integer id);
	
	// 4. Get one Product
	Product getOneProduct(Integer id);
	
	// 5. Get All Product
	List<Product> getAllProduct();

}
