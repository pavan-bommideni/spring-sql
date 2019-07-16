package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.respository.IUserRepository;

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
	

}
