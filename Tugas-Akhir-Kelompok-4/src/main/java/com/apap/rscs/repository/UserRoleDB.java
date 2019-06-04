package com.apap.rscs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.rscs.model.UserRoleModel;

@Repository
public interface UserRoleDB extends JpaRepository<UserRoleModel, Long> {
	UserRoleModel findByUsername(String username);
}
