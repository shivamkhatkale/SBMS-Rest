package com.example.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class ExController {

	@GetMapping("/cart")
	public ResponseEntity<String> showMessage() {

		return ResponseEntity.ok("WELCOME TO SPRINGBOOT");

	}

}
