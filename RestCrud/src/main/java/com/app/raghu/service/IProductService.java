package com.app.raghu.service;

import java.util.List;

import com.app.raghu.dto.ProductDTO;
import com.app.raghu.entity.Product;

public interface IProductService {

	Integer saveProduct(ProductDTO product);

	Product getOneProduct(Product product);

	void deleteOneProduct(Integer id);

	void updateOneProduct(Integer id);

	List<Product> getAllProduct(Product product);

}
