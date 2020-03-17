package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String indexForRoot() {
		return "Greetings from Spring Boot!\nYou are at root";
	}

	@GetMapping("/")
	public String indexForGet() {
		return "Greetings from Spring Boot!\nThis is Get";
	}

	@PostMapping("/")
	public String indexForPost() {
		return "Greetings from Spring Boot!\nThis is Post";
	}

	@PutMapping("/")
	public String indexForPut() {
		return "Greetings from Spring Boot!\nThis is Put";
	}

	@DeleteMapping("/")
	public String indexForDelete() {
		return "Greetings from Spring Boot!\nThis is Delete";
	}
}
