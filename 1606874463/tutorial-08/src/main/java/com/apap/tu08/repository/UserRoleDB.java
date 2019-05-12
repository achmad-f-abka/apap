package com.apap.tu08.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tu08.model.UserRoleModel;

public interface UserRoleDB extends JpaRepository<UserRoleModel, Long>{
	Optional<UserRoleModel> findByUsername(String username);
}
