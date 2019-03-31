package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;

public interface PilotService {
	PilotModel getPilotByLicenseNumber(String licenseNumber);
	
	void addPilot(PilotModel pilot); 
	
	PilotModel getPilotById(Long id);

	void delete(Long id);
	
	void update(PilotModel flight);
}