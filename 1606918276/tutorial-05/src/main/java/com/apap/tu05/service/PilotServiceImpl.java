package com.apap.tu05.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.PilotDb;


@Service
@Transactional

public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber (String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot (PilotModel pilot) {
		pilotDb.save(pilot);
	}

	@Override
	public void deletePilot(long id) {
		pilotDb.deleteById(id);
		
	}
	
	@Override
	public Optional<PilotModel> getPilotById(long id) {
		return pilotDb.findById(id);
		
	}

}

