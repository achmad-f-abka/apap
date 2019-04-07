package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;

/**
 * PilotService
 * */

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licesenseNumber);
	void addPilot(PilotModel pilot);
	void deletePilot(Long id);

}
