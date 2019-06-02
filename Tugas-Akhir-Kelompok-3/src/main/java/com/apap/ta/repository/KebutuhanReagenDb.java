package com.apap.ta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.KebutuhanReagenModel;

@Repository
public interface KebutuhanReagenDb extends JpaRepository<KebutuhanReagenModel, Integer>{
	
	Optional<KebutuhanReagenModel> findById(int id);

}
