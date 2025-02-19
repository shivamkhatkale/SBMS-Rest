package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IProductService;
import com.example.demo.student.Product;

@Service
public class ServiceImpl implements IProductService {

	@Autowired
	private ProductRepository prepo;

	@Override
	public Integer createProduct(Product product) {
		Product a = prepo.save(product);
		return a.getPId();
	}

	@Override
	public Product getOneProduct(Integer id) {

		return prepo.findById(id).orElseThrow(() -> 
		new ProductNotFoundException("Product " + id + " is not exist"));

	}

	@Override
	public void deleteOneProduct(Integer id) {
		prepo.delete(getOneProduct(id));
	}

	@Override
	public List<String> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
