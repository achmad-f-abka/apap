package com.apap.tu05.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDb flightdb;
	
	
	@Override
	public void addFlight(FlightModel flight) {
		flightdb.save(flight);
	}

	@Override
	public List<FlightModel> getPilotByLicenseNumber(String pilotLicenseNumber) {
		return flightdb.findByPilotLicenseNumber(pilotLicenseNumber);
	}

	@Override
	public void delete(Long id) {
		flightdb.deleteById(id);
		
	}

	@Override
	public FlightModel getFlightById(Long id) {
		return flightdb.findById(id).get();
	}

	@Override
	public void update(FlightModel flight) {
		flightdb.save(flight);
		
	}
	
	@Override
	public List<FlightModel> getAllFlight(){
		List<FlightModel> listFlight = (List<FlightModel>) flightdb.findAll();
		return listFlight;
	}
	
}
