package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;
/**
 * PilotService
 */
public interface PilotService {
	PilotModel getPilotDetailBYLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	
}
