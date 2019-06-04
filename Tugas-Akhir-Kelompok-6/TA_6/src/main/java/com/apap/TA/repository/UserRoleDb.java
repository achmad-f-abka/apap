package com.apap.TA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apap.TA.model.UserRoleModel;

@Repository
@Transactional
public interface UserRoleDb extends JpaRepository<UserRoleModel, Integer> {
	UserRoleModel findByUsername(String username);
}

