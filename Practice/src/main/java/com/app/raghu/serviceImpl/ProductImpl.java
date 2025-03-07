package com.app.raghu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.entity.Product;
import com.app.raghu.exception.ProductNotFoundException;
import com.app.raghu.repo.ProductRepository;
import com.app.raghu.service.IService;

@Service
public class ProductImpl implements IService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer createOneProduct(Product p) {
		Product save = repo.save(p);
		return save.getIid();
	}

	@Override
	public void deleteProduct(Integer id) {

		repo.deleteById(id);
	}

	@Override
	public Product getOneProduct(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("ProductEntity Not Found " + id));
	}

	@Override
	public void UpdateProduct(Product p) {

		repo.save(p);

	}

	@Override
	public List<Product> getAllProduct() {

		return repo.findAll();

	}

}
