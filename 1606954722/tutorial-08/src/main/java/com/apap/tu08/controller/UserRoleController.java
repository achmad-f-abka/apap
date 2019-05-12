package com.apap.tu08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private String addUserSubmit(@ModelAttribute UserRoleModel user) {
		userService.addUser(user);
		return "home";
	}
	@RequestMapping(value="/updateUser", method=RequestMethod.GET)
	private String updateUser (Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserRoleModel user = userService.getUserByUsername(authentication.getName());
		model.addAttribute("user", user);
		return "update-password";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	private String updateUserSubmit(@ModelAttribute UserRoleModel user, Model model) {
		UserRoleModel archive = userService.getUserByUsername(user.getUsername());
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(user.getPasswordLama(),archive.getPassword())){
            archive.setPassword(user.getPassword());
            userService.addUser(archive);
            return "home";
        }else{
            model.addAttribute("user", user);
            model.addAttribute("errorMessage", "Password Salah!");
            return "update-password";
        }
	}
}
