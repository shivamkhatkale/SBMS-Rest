package com.raghu.app.rest;

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
import com.raghu.app.entity.Product;
import com.raghu.app.service.IProductService;

@RestController
@RequestMapping("/v1/api/customer")
public class MyController {

	@Autowired
	private IProductService service;

	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody Product p) {
		System.out.println(p);
		Integer id = service.createProduct(p);
		System.out.println("Product " + id + " Created");
		return new ResponseEntity<>("Product " + id + " Created", HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<Product> fetchProduct(@PathVariable Integer id) {

		Product oneProduct = service.getOneProduct(id);
		return new ResponseEntity<>(oneProduct, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {

		service.deleteProduct(id);
		return new ResponseEntity<>("Product " + id + " deleted", HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyProduct(@RequestBody Product product) {

		Integer modifyProduct = service.modifyProduct(product);
		return new ResponseEntity<>("Product " + modifyProduct + " updated", HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> allProduct() {

		List<Product> allProduct = service.getAllProduct();
		return new ResponseEntity<>(allProduct, HttpStatus.OK);

	}

}
