package com.apap.tu08.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tu08.model.PilotModel;
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
	private String update(@RequestParam(value = "username") String username, Model model) {
		Optional<UserRoleModel> archive = userService.getUserByUsername(username);
		model.addAttribute("user", archive.get());
		return "home";
	}
	
	@RequestMapping(value="/updatePassword", method=RequestMethod.POST)
	private @ResponseBody String
	updatePasswordSubmit(String password, Model model) {
		Optional<UserRoleModel> user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		userService.updatePassword(user.get(), password);
		return "update";
	}
	
}
