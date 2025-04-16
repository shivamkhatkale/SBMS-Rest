package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;

@RestController
@RequestMapping("/v1/api/cont")
public class PController {

	@GetMapping("/showA")
	public ResponseEntity<String> showMsg1() {
		return ResponseEntity.ok("WELCOME to SHow A");
	}

	@GetMapping("/showB/{id}/{name}")
	public ResponseEntity<String> showMsg2(@PathVariable Integer id, @PathVariable String name) {
		return ResponseEntity.ok("WELCOME to SHow A" + id + name);
	}

	@GetMapping("/showC")
	public ResponseEntity<Book> showMsg3() {
		return ResponseEntity.ok(new Book(101, "ABC", "RAJ", 5000.0));
	}

	@PostMapping("/showD")
	public ResponseEntity<String> showMsg4(@RequestBody Book b) {
		return ResponseEntity.ok("Date Product " + b.getBid() + " Created");
	}

	@PostMapping("/showE")
	public ResponseEntity<String> showMsg5(@RequestBody Book b) {
		return ResponseEntity.ok("Product Created " + b.getBid());
	}

}
