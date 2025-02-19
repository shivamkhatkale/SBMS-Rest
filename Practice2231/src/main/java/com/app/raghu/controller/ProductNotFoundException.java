package com.app.raghu.controller;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException() {
		super();
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
		
	
}
