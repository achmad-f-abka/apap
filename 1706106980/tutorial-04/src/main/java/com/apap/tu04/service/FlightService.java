package com.apap.tu04.service;
import java.util.List;
import java.util.Optional;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;


/**
 * 
 * FlightService 
 *
 */
 
public interface FlightService {
	void addFlight (FlightModel flight);
	void deleteFlight(long id);
	Optional<FlightModel> getFlightDetailById(Long id);
	List<FlightModel> viewAllFlight();
	List<FlightModel> getFlightListByPilot (PilotModel pilot);	
}