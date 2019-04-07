package com.apap.tu04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.PilotDb;

/**
 * PilotServiceImpl
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}
	
	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}

//	@Override
//	public void updatePilot(String licenseNumber, PilotModel pilot) {
//		PilotModel pilotData = pilotDb.findByLicenseNumber(licenseNumber);
//        pilotData.setName(pilot.getName());
//        pilotData.setFlyHour(pilot.getFlyHour());
//	}

	@Override
	public void updatePilot(PilotModel pilot, String licenseNumber) {
		// TODO Auto-generated method stub
		PilotModel pilotData = pilotDb.findByLicenseNumber(licenseNumber);
        pilotData.setName(pilot.getName());
        pilotData.setFlyHour(pilot.getFlyHour());
        pilotDb.save(pilotData);
	}

}
