package com.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String showHomePage() {
		return "Welcome to security";
	}

	@GetMapping("/default")
	public String showDefault() {
		return "Welcome to security";
	}

}
