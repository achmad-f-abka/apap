package com.apap.ta.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.UserRoleModel;

public interface UserRoleDb extends JpaRepository<UserRoleModel, Integer> {
	UserRoleModel findByUsername(String username);

}
