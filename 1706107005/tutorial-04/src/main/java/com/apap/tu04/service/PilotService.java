package com.apap.tu04.service;

import java.util.List;
import java.util.Optional;

import com.apap.tu04.model.PilotModel;
/**
 * PilotService
 * @author USER
 *
 */

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	Optional<PilotModel> getPilotDetailById(Long id);
	void deletePilot(Long id);

}
