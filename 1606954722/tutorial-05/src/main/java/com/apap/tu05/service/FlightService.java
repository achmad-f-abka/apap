package com.apap.tu05.service;
import java.util.List;
import java.util.Optional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;


/**
 * 
 * FlightService 
 *
 */
 
public interface FlightService {
	void addFlight (FlightModel flight);
	void deleteFlightById(long id);
	Optional<FlightModel> getFlightDetailById(Long id);
	List<FlightModel> viewAllFlight();
	List<FlightModel> getFlightListByPilot (PilotModel pilot);
	void updateFlight(Long id, FlightModel newFlight);
	void deleteFlight(String flightNumber);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	
	
}
