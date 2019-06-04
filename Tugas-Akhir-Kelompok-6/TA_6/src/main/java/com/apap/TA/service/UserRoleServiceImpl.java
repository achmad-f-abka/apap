package com.apap.TA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.TA.model.UserRoleModel;
import com.apap.TA.repository.UserRoleDb;
import com.apap.TA.service.UserRoleService;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    private UserRoleDb userDb;


    @Override
    public UserRoleModel addUser(UserRoleModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
}