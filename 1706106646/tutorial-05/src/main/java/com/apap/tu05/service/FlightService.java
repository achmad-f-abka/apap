package com.apap.tu05.service;

import java.util.List;

import com.apap.tu05.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlight(Long id); //Latihan 3
	FlightModel getFlight(Long id); // Latihan 4
	void updateFlight(long id, FlightModel flight); //UPDATE POST
	FlightModel getFlightDetailByFlightNumber(String flightNumber); // Latihan 5 (by ID)
	List<FlightModel> getAllFlight();  // Latihan 5 (viewall)
}