package com.raghu.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.app.entity.Product;
import com.raghu.app.exception.ProductNotFoundException;
import com.raghu.app.repository.ProductRepository;
import com.raghu.app.service.IProductService;

@Service
public class ProductImpl implements IProductService {

	@Autowired
	private ProductRepository prepo;

	@Override
	public Integer createProduct(Product product) {
		Product p = prepo.save(product);
		return p.getId();
	}

	@Override
	public Product getOneProduct(Integer p) {
		return prepo.findById(p).orElseThrow(() -> new ProductNotFoundException("Product " + p + "Not Found"));
	}

	@Override
	public void deleteProduct(Integer p) {
		prepo.deleteById(p);
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> all = prepo.findAll();
		return all;
	}

	@Override
	public Integer modifyProduct(Product product) {

		Product p = prepo.save(product);
		return p.getId();
	}

}
