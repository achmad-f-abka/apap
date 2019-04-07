package com.apap.tu04.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.*;
import com.apap.tu04.repository.*;

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
	public void deletePilot(Long pilotid) {
		pilotDb.deleteById(pilotid);
	}

	@Override
	public Optional<PilotModel> getPilotById(Long pilotid) {
		// TODO Auto-generated method stub
		return pilotDb.findById(pilotid);
	}
}
