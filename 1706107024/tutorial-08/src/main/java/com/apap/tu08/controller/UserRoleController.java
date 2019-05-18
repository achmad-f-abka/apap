package com.apap.tu08.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu08.model.PasswordModel;
import com.apap.tu08.model.UserRoleModel;
import com.apap.tu08.repository.UserRoleDB;
import com.apap.tu08.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserRoleController {
    @Autowired
    private UserRoleService userService;
    @Autowired
    private UserRoleDB userRoleDb;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserRoleModel user, Model model) {
        if (user.getPassword().length() < 8) {
            model.addAttribute("alertmessage", "Password tidak boleh kurang dari 8 karakter!");
            return "home";
        } 
        else {
            if (user.getPassword().matches(".*[a-zA-Z].*") && user.getPassword().matches(".*[0-9].*")) {
                userService.addUser(user);
                model.addAttribute("alertmessage", "User baru berhasil ditambahkan");
                return "home";
            } else {
                model.addAttribute("alertmessage", "Password harus mengandung angka dan huruf");
                return "home";
            }
        }
    }

    public boolean validatePassword(String password) {
        if (password.length() >= 8 && Pattern.compile("[0-9]").matcher(password).find() && Pattern.compile("[a-zA-Z]").matcher(password).find()) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    private String addUserSubmit(Principal principal, @ModelAttribute PasswordModel pass, Model model) {
        UserRoleModel changedUser = userRoleDb.findByUsername(principal.getName());

        PasswordEncoder token = new BCryptPasswordEncoder();

        Boolean passMatch = token.matches(pass.getoldPassword(), changedUser.getPassword());
        Boolean confirmMatch = pass.getnewPassword().equals(pass.getconfirmationPassword());
        Boolean confirmValid = pass.getnewPassword().equals(pass.getconfirmationPassword());
        if (passMatch && confirmMatch && confirmValid) {
            UserRoleModel user = new UserRoleModel();
            user.setId(changedUser.getId());
            user.setUsername(changedUser.getUsername());
            user.setRole(changedUser.getRole());
            user.setPassword(pass.getnewPassword());
            userService.addUser(user);
            model.addAttribute("success", "Success Change Password!");
        }
        else {
            List<String> messages = new ArrayList<String>();
            if (!passMatch) {
                messages.add("Wrong Password");
            }
            if (!confirmMatch) {
                messages.add("Password Doesn't Match");
            }
            if (!confirmValid) {
                messages.add("Password Format not Valid");
            }
            model.addAttribute("error", messages);
        }
        return "home";
    }

}
