package com.security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.api.model.User;
import com.security.api.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/addUser")
	public String addUserByAdmin(@RequestBody User user) {
		String password = user.getPassword();
		String encryptedPassword = passwordEncoder.encode(password);
		user.setPassword(encryptedPassword);
		userRepo.save(user); 
		return "User added successfully";
	} 
}
