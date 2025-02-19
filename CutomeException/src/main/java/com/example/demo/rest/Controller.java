package com.example.demo.rest;

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

import com.example.demo.service.IProductService;
import com.example.demo.student.Product;

@RestController
@RequestMapping("/product")
public class Controller {

	@Autowired
	private IProductService service;

	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		System.out.println("Received Product: " + product);
		service.createProduct(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Product> getOneProduct(@PathVariable Integer id) {

		Product p = service.getOneProduct(id);
		return ResponseEntity.ok(p);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {

		service.deleteOneProduct(id);
		return ResponseEntity.ok("Product " + id + " deleted Successfully ...");

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@PathVariable Integer id)	{
		
		return ResponseEntity.ok("Product  "+id + " updated" );
	}
		
	
}


