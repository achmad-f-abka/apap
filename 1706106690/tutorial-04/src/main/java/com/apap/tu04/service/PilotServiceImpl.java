package com.apap.tu04.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
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
	public List<PilotModel> getAllPilot(){
		return pilotDb.findAll();
	}
	
	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}

}



