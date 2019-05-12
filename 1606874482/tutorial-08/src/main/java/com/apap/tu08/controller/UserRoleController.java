package com.apap.tu08.controller;

import com.apap.tu08.model.PasswordModel;
import com.apap.tu08.model.UserRoleModel;
import com.apap.tu08.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserRoleController {
    @Autowired
    private UserRoleService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserRoleModel user){
        userService.addUser(user);
        return "home";
    }
    @RequestMapping(value = "/updatePasswordUser")
	private String updatePasswordUser() {
		return "updatePassword";
	}
	
	@RequestMapping(value = "/updatePasswordUser", method = RequestMethod.POST)
	private String updatePasswordUserSubmit(@ModelAttribute PasswordModel password, Model model, RedirectAttributes redirect) {
		UserRoleModel user = userService.getUserDetailByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		String pesan = userService.checkUpdatePassword(password, user);
		redirect.addFlashAttribute("pesan", pesan);
		return "redirect:/user/updatePasswordUser";
	}
}
