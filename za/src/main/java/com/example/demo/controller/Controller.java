package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.serviceimpl.ProductImpl;

@RestController
@RequestMapping("/v1/api/Student")
public class Controller {

	@Autowired
	private ProductImpl service;

	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody ProductEntity pp) {

		service.createOneProduct(pp);
		return ResponseEntity.ok("Product " + pp.getId() + " created");
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ProductEntity> fetchOneProduct(@PathVariable Integer id) {

		ProductEntity one = service.getOneProduct(id);
		return ResponseEntity.ok(one);
	}

	@GetMapping("/fetch-all")
	public ResponseEntity<List<ProductEntity>> getAllData() {

		return ResponseEntity.ok(service.getAllList());
	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyProduct(@RequestBody ProductEntity p) {
		service.updateProduct(p);
		return ResponseEntity.ok("Product " + p.getId() + " Updated Successfully...");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		service.deleteOneProduct(id);
		return ResponseEntity.ok("Product " + id + " Delete Successfully");
	}

}
