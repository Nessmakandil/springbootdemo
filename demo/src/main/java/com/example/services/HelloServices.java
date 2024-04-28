package com.example.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/rest")
public class HelloServices {
	@GetMapping("/hello")
	public String sayHelloGet() {
		return "returning from get";
	}
	@PostMapping("/hello")
	public String sayHelloPost() {
		return "returning from post";
	}
}
