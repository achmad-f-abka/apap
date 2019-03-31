package com.apap.tu04.service;

import java.util.List;

import com.apap.tu04.model.FlightModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
}
