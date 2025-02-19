package com.app.raghu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class EmployeeController {

	@GetMapping("/v1/api/{id}")
	public ResponseEntity<String> shw(@PathVariable Integer id) {

		if (id % 2 == 0)
			return ResponseEntity.ok("Thanks a alot");
		else
			throw new EmployeeNotFoundException("Thank You, I am Happy..");
	}
	

}
