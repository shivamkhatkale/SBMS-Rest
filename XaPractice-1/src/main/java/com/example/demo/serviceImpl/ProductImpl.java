package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IService;

@Service
public class ProductImpl implements IService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(ProductEntity productEntity) {
		productEntity = repo.save(productEntity);
		return productEntity.getPid();
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.delete(getOneProduct(id));
	}

	public ProductEntity getOneProduct(Integer id) {
		return repo.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("ProductEntity " + id + " is not exist"));
	}

	@Override
	public List<ProductEntity> fetchAll() {

		return repo.findAll();

	}

	@Override
	public void updateProduct(ProductEntity p) {

		if (p.getPid() == null || !repo.existsById(p.getPid())) {
			throw new ProductNotFoundException("Student " + p.getPid() + " Not Exist");
		} else {
			repo.save(p);
		}
	}

}
