package com.apap.tu05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.repository.FlightDb;


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
	public List<FlightModel> getAllFlight() {
		return flightDb.findAll();
	}

	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	@Override
	public void deleteFlight(String flightNumber) {
		flightDb.delete(this.getFlightDetailByFlightNumber(flightNumber));
	}
	
	@Override
	public void updateFlight(String flightNumber, FlightModel newFlight) {
		FlightModel flightLama = this.getFlightDetailByFlightNumber(flightNumber);
		flightLama.setFlightNumber(newFlight.getFlightNumber());
		flightLama.setOrigin(newFlight.getOrigin());
		flightLama.setDestination(newFlight.getDestination());
		flightLama.setTime(newFlight.getTime());
	}
	
	// tambahan
	@Override
	public FlightModel findById(long id) {
		List<FlightModel> flights = flightDb.findAll();
		FlightModel count = new FlightModel();
		for(FlightModel flight:flights) {
			if(flight.getId()==id) {
				count = flight;
			}
		}
		return count;
	}

	@Override
	public FlightModel getFlight(long id) {
		String idnya = "" + id;
		return flightDb.findByFlightNumber(idnya);
	}
	
	@Override
	public void deleteFlightById(long id) {
		flightDb.deleteById(id);
	}
	// ...
}
