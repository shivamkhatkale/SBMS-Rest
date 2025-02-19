package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.IService;

//@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/v1/api/pro")
public class ProductController {

	@Autowired
	private IService service;

	@PostMapping("/create")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		System.out.println(product);

		Integer id = service.saveProduct(product);
		return new ResponseEntity<String>("Product " + id + " saved Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {

		ResponseEntity<String> response = null;
		try {
			service.deleteProduct(id);
			response = ResponseEntity.ok("Product " + id + " REMOVED");
		} catch (ProductNotFoundException p) {
			p.printStackTrace();
			throw p;
		}
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getOneProduct(@PathVariable Integer id) {

		ResponseEntity<Product> response = null;
		try {
			Product p = service.getOneProduct(id);
			response = ResponseEntity.ok(p);
		} catch (ProductNotFoundException p) {
			p.printStackTrace();
			throw p;
		}
		return response;
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<Product>> fetchAllProduct() {

		List<Product> ll = service.fetchAll();
		return new ResponseEntity<List<Product>>(ll, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {

		ResponseEntity<String> response = null;

		try {
			service.updateProduct(product);
			response = ResponseEntity.ok("STDUENT " + product.getPid() + " UPDATED");
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;

	}
	
	
	
	
	

}
