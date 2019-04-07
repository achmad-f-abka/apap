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
	void deletePilot (long id);
	Optional<PilotModel> getPilotById(long id);
	
	

}
