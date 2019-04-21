package com.apap.tu5.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu5.model.FlightModel;
import com.apap.tu5.model.PilotModel;
import com.apap.tu5.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;

	@Override
	public void addFlight(FlightModel flight) {
		// TODO Auto-generated method stub
		flightDb.save(flight);
	}

	@Override
	public List<FlightModel> getAllFlight(){
		return flightDb.findAll();
	}

	@Override
	public void deleteFlight(PilotModel pilot, String flightNumber) {
		flightDb.deleteByPilotAndFlightNumber(pilot, flightNumber);
	}

	@Override
	public FlightModel getFlight(PilotModel pilot, String flightNumber) {
		// TODO Auto-generated method stub
		return flightDb.findByPilotAndFlightNumber(pilot, flightNumber);
	}

	@Override
	public void updateFlight(FlightModel flight) {
		flightDb.save(flight);

	}



}