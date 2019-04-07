package com.apap.tu04.service;

import java.util.Optional;

import com.apap.tu04.model.*;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	void deletePilot(Long pilotid);
	Optional<PilotModel> getPilotById(Long pilotid);

}
