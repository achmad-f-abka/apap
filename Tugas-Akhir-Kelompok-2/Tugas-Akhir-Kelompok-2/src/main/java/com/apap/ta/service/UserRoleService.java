package com.apap.ta.service;

import com.apap.ta.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	public String encrypt(String password);
	UserRoleModel findUserByUsername(String username);
	boolean validatePassword (UserRoleModel user, String password);

}
