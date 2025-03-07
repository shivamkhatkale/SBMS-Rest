package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.IService;

//@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/v1/api/pro")
public class ProductController {

	@Autowired
	private IService service;

	@PostMapping("/create")
	public ResponseEntity<String> saveProduct(@RequestBody ProductEntity productEntity) {
		System.out.println(productEntity);

		Integer id = service.saveProduct(productEntity);
		return new ResponseEntity<String>("ProductEntity " + id + " saved Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {

		ResponseEntity<String> response = null;
		try {
			service.deleteProduct(id);
			response = ResponseEntity.ok("ProductEntity " + id + " REMOVED");
		} catch (ProductNotFoundException p) {
			p.printStackTrace();
			throw p;
		}
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ProductEntity> getOneProduct(@PathVariable Integer id) {

		ResponseEntity<ProductEntity> response = null;
		try {
			ProductEntity p = service.getOneProduct(id);
			response = ResponseEntity.ok(p);
		} catch (ProductNotFoundException p) {
			p.printStackTrace();
			throw p;
		}
		return response;
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<ProductEntity>> fetchAllProduct() {

		List<ProductEntity> ll = service.fetchAll();
		return new ResponseEntity<List<ProductEntity>>(ll, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody ProductEntity productEntity) {

		ResponseEntity<String> response = null;

		try {
			service.updateProduct(productEntity);
			response = ResponseEntity.ok("STDUENT " + productEntity.getPid() + " UPDATED");
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;

	}

}
