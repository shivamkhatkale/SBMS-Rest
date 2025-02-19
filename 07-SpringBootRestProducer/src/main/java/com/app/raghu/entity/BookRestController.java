package com.app.raghu.entity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/book")
public class BookRestController {

	@GetMapping("/show")
	public ResponseEntity<String> showmsg() {

		// return new ResponseEntity<>("WELCOME TO THE CHANNEL", HttpStatus.OK);

		return ResponseEntity.ok("Welcome to the channel");
	}

	@GetMapping("/data")
	public ResponseEntity<String> showData() {
		return ResponseEntity.ok("Check the code here ");
	}

}
