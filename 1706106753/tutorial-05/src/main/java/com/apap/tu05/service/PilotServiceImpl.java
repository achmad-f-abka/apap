package com.apap.tu05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{

	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
		
	}
	
	@Override
	public void delete(Long id) {
		pilotDb.deleteById(id);
		
	}
	
	@Override
	public void update(PilotModel pilot) {
		pilotDb.save(pilot);
		
	}

	@Override
	public PilotModel getPilotById(Long id) {
		return pilotDb.findById(id).get();
	}

	
}
