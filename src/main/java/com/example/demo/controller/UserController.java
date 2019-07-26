package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;
	
	
	@PostMapping("/users")
	public Boolean createUser(@RequestBody UserModel userModel) {
		return userService.createUser(userModel);
	}
	
	
	@GetMapping("/users")
	public List<User> get() {
		return userService.getUsers();
	}
	
	@PostConstruct
	public void getTest() {
		System.out.println("Test Logs");
		System.out.println("url: "+url+" username: "+username + " password: "+password);
	}
	
}
