package com.apap.ta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.StaffModel;

@Repository
public interface StaffDb extends JpaRepository<StaffModel, Integer>{

		Optional<StaffModel> findById(int id);
}
