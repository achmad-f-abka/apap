package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;

/**
 * PilotService
 */

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	void deletePilot(PilotModel pilot);
	void updatePilot(PilotModel pilot, String licenseNumber);
//	void updatePilot(String licenseNumber, PilotModel pilot);
}
