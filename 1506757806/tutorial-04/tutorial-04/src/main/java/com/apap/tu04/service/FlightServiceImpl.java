package com.apap.tu04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.FlightModel;
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
		System.out.println(flight.getDestination());
		System.out.println(flight.getFlightNumber());
		System.out.println(flight.getOrigin());
		System.out.println(flight.getPilot().getLicenseNumber());
		flightDb.save(flight);
	}
	
	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}

	@Override
	public List<FlightModel> getFlightList() {
		// TODO Auto-generated method stub
		return flightDb.findAll();
	}

	@Override
	public void deleteFlight(long id) {
		flightDb.deleteById(id);
	}
}
