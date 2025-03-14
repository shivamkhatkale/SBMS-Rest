package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.UserNotFoundException;

@ControllerAdvice
public class MyCustomException {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException unfe) {

		return new ResponseEntity<>("Product not FOund ", HttpStatus.BAD_REQUEST);

	}

}
