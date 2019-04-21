package com.apap.tu04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.FlightDb;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public List<FlightModel> getFlightListByPilot(PilotModel pilot) {
		List<FlightModel> listFlight = flightDb.findByPilot(pilot);
		return listFlight;
	}

	@Override
	public void deleteFlightById(long id) {
		flightDb.deleteById(id);
		
	}
	
	@Override
	public List<FlightModel> getAllFlightList() {
		List<FlightModel> listFlight = flightDb.findAll();
		return listFlight;

	}
}
