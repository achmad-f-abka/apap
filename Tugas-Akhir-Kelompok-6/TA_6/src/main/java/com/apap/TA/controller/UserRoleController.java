package com.apap.TA.controller;


import com.apap.TA.repository.UserRoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.TA.model.UserRoleModel;
import com.apap.TA.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;

	@Autowired
	private UserRoleDb userRoleDb;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user) {
		String username = user.getUsername();
		if(userRoleDb.findByUsername(username) == null) {
				userService.addUser(user);
				return "home";
		}
		return "username-exist";
	}

}