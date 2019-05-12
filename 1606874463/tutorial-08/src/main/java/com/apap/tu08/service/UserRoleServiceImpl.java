package com.apap.tu08.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.apap.tu08.model.UserRoleModel;
import com.apap.tu08.repository.UserRoleDB;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleDB userDb;
	
	@Override
	public UserRoleModel addUser(UserRoleModel user) {
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		return userDb.save(user);
	}
	
	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
	@Override
	public Optional<UserRoleModel> getUserByUsername(String username){
		return userDb.findByUsername(username);
	}
	
	@Override
	public UserRoleModel updatePassword(UserRoleModel user, String password) {
		String pass = encrypt(password);
		user.setPassword(pass);
		System.out.println(user.getUsername());
		System.out.println(user.getRole());
		System.out.println(user);
		return userDb.save(user);
	}
	
}
