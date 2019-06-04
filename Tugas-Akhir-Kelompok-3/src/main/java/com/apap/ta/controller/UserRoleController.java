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
@RequestMapping("/lab")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;
	
	@RequestMapping(value="/tambah-user", method=RequestMethod.GET)
	private String tambahUser() {
		return "tambahUser.html";
	}
	
	@RequestMapping(value ="/add-user", method=RequestMethod.POST)
	private String tambahUserSubmit(@ModelAttribute UserRoleModel user, Model model) {
        if (user.getPassword().length() < 8) {
            model.addAttribute("message", "Password tidak boleh kurang dari 8 character");
            return "tambahUser.html";
        } 
        else {
            if (user.getPassword().matches(".*[a-zA-Z].*") && user.getPassword().matches(".*[0-9].*")) {
                userService.addUser(user);
                model.addAttribute("message", "User baru berhasil ditambahkan!");
                return "kelolaUser.html";
            } else {
                model.addAttribute("message", "Password harus terdiri dari angka dan huruf!");
                return "tambahUser.html";
            }
        }
    }
	
	
	@RequestMapping(value="/update-password", method=RequestMethod.GET)
	private String updatePassword() {
		return "updatePassword.html";
	}
	@RequestMapping(value="/update-password", method=RequestMethod.POST)
	private  String update(String username, String passwordLama, String passwordBaru, String passwordKonfirmasi, Model model) {
			UserRoleModel user = userService.findUserByUsername(username);
		
		if (userService.validatePassword(user, passwordLama)) {
			if (passwordBaru.equals(passwordKonfirmasi)) {
				user.setPassword(passwordBaru);
				userService.addUser(user);
				model.addAttribute("message", "Password berhasil diubah!");
			}
			else {
				model.addAttribute("message", "Konfirmasi password tidak sesuai! Silakan ulangi lagi.");
			}
		}
		else {
			model.addAttribute("message", "Password lama tidak sesuai! Silakan masukkan password lama.");
		}
		
		return "updatePassword.html";
	}

}
