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
public class FlightServiceImpl implements FlightService  {

	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}

	@Override
	public List<FlightModel> getFlightList() {
		return flightDb.findAll();
	}
	
	@Override
	public List<FlightModel> getFlightDetailByPilotLicenseNumber(String pilotLicenseNumber){
		return flightDb.findByPilotLicenseNumber(pilotLicenseNumber);
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);
	}
	
	@Override
	public void updateFlight(FlightModel flight, String flightNumber) {
		FlightModel flightDetail = flightDb.findByFlightNumber(flightNumber);
		flightDetail.setOrigin(flight.getOrigin());
		flightDetail.setDestination(flight.getDestination());
		flightDetail.setTime(flight.getTime());
        flightDb.save(flightDetail);
	}
}
