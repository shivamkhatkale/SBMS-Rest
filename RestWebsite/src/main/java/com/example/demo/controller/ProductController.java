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
import com.example.demo.Service.IService;
import com.example.demo.entity.Product;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

	@Autowired
	private IService service;

	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody Product p) {
		Integer id = service.createProduct(p);
		return new ResponseEntity<>("Product " + id + " Created", HttpStatus.CREATED);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Product> getOneProduct(@PathVariable Integer id) {
		Product oneProduct = service.getOneProduct(id);
		return new ResponseEntity<>(oneProduct, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct() {

		List<Product> allProduct = service.getAllProduct();
		return new ResponseEntity<>(allProduct, HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyProduct(@RequestBody Product p) {
		service.modifyProduct(p);
		return ResponseEntity.ok("Product " + p.getId() + " Updated Successfully...");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
		return ResponseEntity.ok("Delete " + id + " Product Successfully...");
	}

}
