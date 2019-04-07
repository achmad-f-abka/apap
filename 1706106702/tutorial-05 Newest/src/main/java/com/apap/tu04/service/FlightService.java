package com.apap.tu04.service;

import java.util.List;

import com.apap.tu04.model.FlightModel;

/**
 * FlightService
 */

public interface FlightService {
	void addFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void deleteFlight(long id);
	List<FlightModel> getFlightList();
	FlightModel findById(long id);
	FlightModel getFlight(long id);
}
