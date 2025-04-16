package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Service.IService;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;

public class ServiceImpl implements IService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer createProduct(Product p) {
		Product save = repo.save(p);
		return save.getId();
	}

	@Override
	public void modifyProduct(Product p) {
		repo.save(p);
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Product getOneProduct(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found ...."));
	}

	@Override
	public List<Product> getAllProduct() {
		return repo.findAll();
	}

}
