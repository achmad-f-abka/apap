package com.apap.tu05.service;

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
	void updatePilot(Long id, PilotModel newPilot);
	void deletePilot(Long id);



	

	
	

}