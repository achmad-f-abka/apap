package com.apap.tu08.service;

import com.apap.tu08.model.PasswordModel;
import com.apap.tu08.model.UserRoleModel;

public interface UserRoleService {
    UserRoleModel addUser(UserRoleModel user);
    public String encrypt(String password);
    String checkPassword(String password);
	String checkUpdatePassword(PasswordModel password, UserRoleModel user);
	void gantiPassword(UserRoleModel user, String passwordBaru);
	UserRoleModel getUserDetailByUsername(String username);
}