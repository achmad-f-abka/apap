package com.apap.tu05.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.FlightDb;


/**
 * FlightServiceImpl
 */

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight (FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public Optional<FlightModel> getFlightDetailById(Long id){
		return flightDb.findById(id);
	}
	@Override
	public List<FlightModel> viewAllFlight(){
		List<FlightModel> list = flightDb.findAll();
		return list;
	}
	@Override
	public List<FlightModel> getFlightListByPilot(PilotModel pilot) {
		List<FlightModel> listFlight = flightDb.findByPilot(pilot);
		return listFlight;
	}

	@Override
	public void deleteFlight(long id) {
		flightDb.deleteById(id);
		
	}
	@Override
	public void updateFlight(Long id, FlightModel newFlight) {
		FlightModel flight = this.getFlightDetailById(id).get();
		flight.setFlightNumber(newFlight.getFlightNumber());
		flight.setOrigin(newFlight.getOrigin());
		flight.setDestination(newFlight.getDestination());
		flight.setTime(newFlight.getTime());
	}
	
}
