package com.apap.tu05.service;

import java.util.List;
import java.util.Optional;

import com.apap.tu05.model.FlightModel;

public interface FlightService {
	void addFlight(FlightModel flight); 
	
	List<FlightModel> getPilotByLicenseNumber(String pilotLicenseNumber);
	
	FlightModel getFlightById(Long id);

	void delete(Long id);
	
	void update(FlightModel flight);
	
	List<FlightModel> getAllFlight();
}

