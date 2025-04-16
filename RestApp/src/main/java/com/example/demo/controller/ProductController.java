package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.IService;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

	@Autowired
	private IService service;

	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody ProductEntity p) {
		service.createProduct(p);
		return ResponseEntity.ok("Product "+ p.getPid() +" Created... ");
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
		return ResponseEntity.ok("Product " + id + "  is deleted...");
	}

	@GetMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody ProductEntity p) {
		service.modifyProduct(p);
		return ResponseEntity.ok("Product " + p.getPid() + " updated...");
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ProductEntity> getOneProduct(@PathVariable Integer id) {
		ProductEntity oneProduct = service.getOneProduct(id);
		return ResponseEntity.ok(oneProduct);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductEntity>> allProduct() {
		List<ProductEntity> allProduct = service.getAllProduct();
		return ResponseEntity.ok(allProduct);
	}

}
