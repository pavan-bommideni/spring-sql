package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.respository.IUserRepository;

import javax.annotation.PostConstruct;

@Service
public class UserService {
	
	@Autowired
	IUserRepository userRepository;
	
	public Boolean createUser(UserModel userModel) {
		User user = new User();
		user.setEmailAddress(userModel.getEmailAddress());
		user.setName(userModel.getName());
		userRepository.save(user);
		return true;
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	@PostConstruct
	public void loadData(){
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			User user = new User();
			user.setEmailAddress("P"+i+"@p.com");
			user.setName("P"+i);
			users.add(user);
		}
		userRepository.saveAll(users);
	}

}
