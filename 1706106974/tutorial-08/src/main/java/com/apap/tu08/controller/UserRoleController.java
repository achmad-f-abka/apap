package com.apap.tu08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu08.model.UserRoleModel;
import com.apap.tu08.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;
	
	String regex = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,}";
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user) {
		userService.addUser(user);
		return "home";
	}
	@RequestMapping(value="/updatePassword", method=RequestMethod.POST)
    private String updatePasswordSubmit(String newPassword, 
    		String confirmPassword,
    		Model model, String oldPassword, String username) {
    	UserRoleModel user = userService.findUserByUsername(username);
    	
    	if (userService.validateOldPassword(user, oldPassword)) {
    		if (newPassword.equals(confirmPassword)) {
    				user.setPassword(newPassword);
    				userService.addUser(user);
    				model.addAttribute("message", "password has been updated!");
    		} else {
    				model.addAttribute("message", "you have "
    						+ "inputted the wrong new password");
    		}
    	} else {
    		model.addAttribute("message", "wrong old password");
    	}
    	return "home";
    }

}
