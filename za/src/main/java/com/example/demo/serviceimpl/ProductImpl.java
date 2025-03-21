package com.example.demo.serviceimpl;

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
	public Integer createOneProduct(ProductEntity p) {

		ProductEntity pp = repo.save(p);
		return pp.getId();
	}

	@Override
	public ProductEntity getOneProduct(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found..."));
	}

	@Override
	public void deleteOneProduct(Integer id) {

		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
		} else {
			throw new ProductNotFoundException("Product Not Found ....");
		}

	}

	@Override
	public List<ProductEntity> getAllList() {

		List<ProductEntity> al = repo.findAll();
		return al;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity p) {
		return repo.save(p);
	}

}
