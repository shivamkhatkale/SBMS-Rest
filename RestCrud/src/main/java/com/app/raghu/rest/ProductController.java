package com.app.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.dto.ProductDTO;
import com.app.raghu.service.IProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/api/product")
@AllArgsConstructor
public class ProductController {

	private IProductService service;

	@PostMapping("/create")
	public ResponseEntity<String> saveProduct( @RequestBody @Valid ProductDTO product) {
		System.out.println("Printing here .."+ product);
		Integer id = service.saveProduct(product);
		return new ResponseEntity<>("Product " + id + " Found", HttpStatus.OK);
	}

}
