package com.app.tu05.service;

import java.util.List;

import com.app.tu05.model.FlightModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	void deleteFlight(String flightNumber);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void updateFlight(String flightNumber, FlightModel flight);
}
