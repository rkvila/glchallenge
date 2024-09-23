package com.glchallenge.controller;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glchallenge.model.User;
import com.glchallenge.service.IUserService;

@RestController
@Validated
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/signup")
	public User createUser(@Valid @RequestBody User user) {
		// Save user
		userService.saveUser(user);
		return user;
	}
	
	/*
	@PostMapping("/login")
	public String login() {
		return "";
	}*/
	
	
	
	@GetMapping("/login/{token}")
	public User findUserByToken(@PathVariable Long token) {
		return userService.findUserByToken(token);
	}
}
