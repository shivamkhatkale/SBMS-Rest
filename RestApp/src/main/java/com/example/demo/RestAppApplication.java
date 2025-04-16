package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
info = @Info(
        title = "RestApp API",
        version = "1.0",
        description = "API documentation for RestApp",
        contact = @Contact(name = "Shivam", email = "shivamkhatkale5@gmail.com")
	    )
)	
public class RestAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}

}
