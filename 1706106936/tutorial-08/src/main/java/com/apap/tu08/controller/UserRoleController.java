package com.apap.tu08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tu08.model.UserRoleModel;
import com.apap.tu08.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user) {
		userService.addUser(user);
		return "home";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.GET)
	private String update() {
		return "update-password";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.POST)
	private  String updateSubmit(String username, String oldPassword, String newPassword, String confirmPassword, Model model) {
			UserRoleModel user = userService.findUserByUsername(username);
		
		if (userService.validatePassword(user, oldPassword)) {
			if (newPassword.equals(confirmPassword)) {
				user.setPassword(newPassword);
				userService.addUser(user);
				model.addAttribute("notif", "Password Berhasil Diubah");
			}
			else {
				model.addAttribute("notif", "konfirmasi password tidak sesuai!");
			}
		}
		else {
			model.addAttribute("notif", "Password lama tidak sesuai!");
		}
		
		return "update-password";
	}
	
	
}
