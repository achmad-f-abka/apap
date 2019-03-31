package com.apap.tu04.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu04.model.PilotModel;

@Repository
public interface PilotDb extends CrudRepository<PilotModel, Long>{

	PilotModel findByLicenseNumber(String licenseNumber);
	
}