package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(User user) {
		
		if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("User already exists");
        }
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}

}
