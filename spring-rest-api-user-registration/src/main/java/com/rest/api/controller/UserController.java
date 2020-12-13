package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.UserRegistration;
import com.rest.api.model.UserRegistrationDateCount;
import com.rest.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserRegistration> retrieveUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/users")
	public void createUsers(@RequestBody UserRegistration user) {
		userService.setUsers(user);
	}
	
	@GetMapping("/users/count")
	public Integer retrieveUserRegistrationCount() {
		return userService.getUserRegistration();
	}
	
	@GetMapping("/users/monthlycount")
	public List<UserRegistrationDateCount> retrieveCount(){
		return userService.getCount();
	}
}
