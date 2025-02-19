package com.app.raghu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/check/{id}")
	public ResponseEntity<String> getProductById(

			@PathVariable("id") Integer id

	) {

		if (id < 150) {
			return new ResponseEntity<>("Product Exist", HttpStatus.OK);
		} else {

			throw new ProductNotFoundException("Product Not Found " + id); 
		}

	}

}
