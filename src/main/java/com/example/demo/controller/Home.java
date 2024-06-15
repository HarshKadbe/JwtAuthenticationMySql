package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;

@RestController
public class Home {
	
	@GetMapping("/welcome")
	public String welcome() {
		String text = "This is private page";
		text+="this page not allowed";
		return text;
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		userService.registerUser(user);
		return "User registered successfully";
	}

}
