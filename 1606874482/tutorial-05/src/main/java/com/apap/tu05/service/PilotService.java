package com.apap.tu05.service;

import java.util.List;

import java.util.Optional;


import com.apap.tu05.model.PilotModel;

/**
 * 
 * PilotService
 *
 */


public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber (String licenseNumber);
	void addPilot (PilotModel pilot);
	Optional<PilotModel> getPilotDetailById(Long id);
	
	void deletePilot(Long id);



	

	
	

}
