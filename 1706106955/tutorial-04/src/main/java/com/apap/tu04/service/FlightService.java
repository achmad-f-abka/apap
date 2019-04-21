package com.apap.tu04.service;

import java.util.List;
import com.apap.tu04.model.FlightModel;

/*
 * FlightService
 */
public interface FlightService {
	void addFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	void deleteFlight(String flightNumber);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void updateFlight(String flightNumber, FlightModel flight);
}
