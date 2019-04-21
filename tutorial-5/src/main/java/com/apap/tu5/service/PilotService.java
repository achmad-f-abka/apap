package com.apap.tu5.service;

import java.util.List;

import com.apap.tu5.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	List<PilotModel> getAllPilot();
	void deletePilot(PilotModel pilot);
}
