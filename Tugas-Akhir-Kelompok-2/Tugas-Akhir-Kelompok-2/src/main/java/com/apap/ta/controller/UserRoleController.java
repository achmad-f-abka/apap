package com.apap.ta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.ta.model.UserRoleModel;
import com.apap.ta.service.UserRoleService;

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
	
	@RequestMapping(value="/tambah-user", method=RequestMethod.GET)
	private String tambahUser() {
		return "tambah-user";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.GET)
	private String updatePassword() {
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
