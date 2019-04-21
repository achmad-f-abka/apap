package com.apap.tu05.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.FlightDb;
import com.apap.tu05.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;
	private FlightDb flightDb;
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addPilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		pilotDb.save(pilot);
	}
	
	@Override
	public List<PilotModel> getAllPilot(){
		return pilotDb.findAll();
	}
	
	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}
	
}