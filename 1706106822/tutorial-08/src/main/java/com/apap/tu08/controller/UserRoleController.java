package com.apap.tu08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	private String addUsersubmit(@ModelAttribute UserRoleModel user) {
		userService.addUser(user);
		return "home";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.GET)
	private String update(@ModelAttribute UserRoleModel user) {
		return "update-pass";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.POST)
	private String updatePasswordSubmit(String oldPassword, String newPassword, String confirmPassword, Model model) {
		UserRoleModel user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		
		if(newPassword.equals(confirmPassword)) {
			
			if(userService.matchPassword(oldPassword, user.getPassword())) {
				user.setPassword(newPassword);
				userService.addUser(user);
				
				model.addAttribute("msg", "Password " + user.getUsername() + " berhasil diubah");
				return "success-updatePass";
			}
			
			else {
				model.addAttribute("msg", "password lama salah");
				return "update-pass";
			}
			
			
		}
		else {
			model.addAttribute("msg", "password konfirmasi tidak sesuai");
			return "update-pass";
		}
	}
}
