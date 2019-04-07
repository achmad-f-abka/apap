package com.apap.tu05.service;

import java.util.List;

import com.apap.tu05.model.FlightModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
}
