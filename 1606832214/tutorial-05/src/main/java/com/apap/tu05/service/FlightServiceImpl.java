package com.apap.tu05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;

	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	
	@Override
	public void deleteFlight(Long flightId) {
		flightDb.deleteById(flightId);
	}
	
	@Override
	public List<FlightModel> getFlightListByPilot(PilotModel pilot) {
		List<FlightModel> listFlight = pilot.getPilotFlight();
		return listFlight;
	}
	
	@Override
	public List<FlightModel> getAllFlightList() {
		List<FlightModel> listFlight = flightDb.findAll();
		return listFlight;

	}
}

