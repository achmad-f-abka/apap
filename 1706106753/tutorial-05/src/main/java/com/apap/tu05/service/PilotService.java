package com.apap.tu05.service;

import com.apap.tu05.model.PilotModel;

public interface PilotService {
	PilotModel getPilotByLicenseNumber(String licenseNumber);
	
	void addPilot(PilotModel pilot); 
	
	PilotModel getPilotById(Long id);

	void delete(Long id);
	
	void update(PilotModel flight);
}
