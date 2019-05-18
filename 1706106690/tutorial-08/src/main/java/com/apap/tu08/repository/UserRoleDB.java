package com.apap.tu08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tu08.model.UserRoleModel;

public interface UserRoleDB extends JpaRepository<UserRoleModel, Long>{
	UserRoleModel findByUsername(String username);

}

