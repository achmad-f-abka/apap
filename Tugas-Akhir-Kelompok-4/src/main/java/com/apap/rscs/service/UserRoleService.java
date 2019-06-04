package com.apap.rscs.service;

import com.apap.rscs.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	public String encrypt(String password);
}
