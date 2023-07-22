package com.sherbin.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherbin.portfolio.model.User;
import com.sherbin.portfolio.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")

@CrossOrigin(origins="http://localhost:4200/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//get all user 
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	//create a user
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}