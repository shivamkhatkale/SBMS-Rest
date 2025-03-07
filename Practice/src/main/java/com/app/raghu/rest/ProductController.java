package com.app.raghu.rest;

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

import com.app.raghu.entity.Product;
import com.app.raghu.service.IService;

@RestController
@RequestMapping("/v1/api/productdara")
public class ProductController {

	@Autowired
	private IService service;

	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody Product p) {

		Integer id = service.createOneProduct(p);
		return ResponseEntity.ok("ProductEntity " + id + " Created");

	}

	@GetMapping("/fetch")
	public ResponseEntity<Product> fetchProduct(@PathVariable Integer id) {

		Product oneProduct = service.getOneProduct(id);
		return ResponseEntity.ok(oneProduct);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
		return ResponseEntity.ok("ProductEntity " + id + "Deleted Successfully...");

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@PathVariable Product product) {

		service.UpdateProduct(product);
		return ResponseEntity.ok("ProductEntity " + product.getIid() + "Updated Successfully...");
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct() {

		List<Product> all = service.getAllProduct();
		return ResponseEntity.ok(all);

	}

}
