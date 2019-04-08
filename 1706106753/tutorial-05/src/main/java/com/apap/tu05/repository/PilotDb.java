package com.apap.tu05.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu05.model.PilotModel;

@Repository
public interface PilotDb extends CrudRepository<PilotModel, Long>{

	PilotModel findByLicenseNumber(String licenseNumber);
	
}
