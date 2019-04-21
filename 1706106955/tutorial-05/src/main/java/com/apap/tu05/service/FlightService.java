package com.apap.tu05.service;

import java.util.List;
import com.apap.tu05.model.FlightModel;

/*
 * FlightService
 */
public interface FlightService {
	void addFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	void deleteFlight(String flightNumber);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void updateFlight(String flightNumber, FlightModel flight);
	// tambahan
	void deleteFlightById(long id);
	FlightModel findById(long id);
	FlightModel getFlight(long id);
	// ...
}