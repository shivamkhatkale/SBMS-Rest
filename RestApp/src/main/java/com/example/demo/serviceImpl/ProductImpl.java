package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepository;
import com.example.demo.service.IService;

@Service
public class ProductImpl implements IService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer createProduct(ProductEntity p) {
		ProductEntity p1 = repo.save(p);
		return p1.getPid();
	}

	@Override
	public void modifyProduct(ProductEntity p) {
		repo.save(p);
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public List<ProductEntity> getAllProduct() {
		return repo.findAll();
	}

	@Override
	public ProductEntity getOneProduct(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product " + id + " Found"));
	}

}
