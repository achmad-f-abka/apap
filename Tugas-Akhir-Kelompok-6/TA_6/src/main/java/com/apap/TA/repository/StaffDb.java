package com.apap.TA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.TA.model.StaffModel;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDb extends JpaRepository<StaffModel, Long>{
	List <StaffModel> findById (int id);
	

}
