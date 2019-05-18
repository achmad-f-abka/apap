package com.apap.tu08.service;

import java.util.Optional;

import com.apap.tu08.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	public String encrypt(String password);
	Optional<UserRoleModel> getUserByUsername(String username);
	UserRoleModel updatePassword(UserRoleModel user, String password);
}
