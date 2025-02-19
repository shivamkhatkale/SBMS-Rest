package com.app.ashokit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/msg")
	public String getMsg() {

		return "Welcome to app";
	}

}
