package com.apap.tu05.service;
import java.util.List;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;


public interface FlightService {
	void addFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void updateFlight(FlightModel flight, String flightNumber);
	void deleteFlight(FlightModel flight);
	void deleteFlightById(long Id);
	List<FlightModel> getFlightList();
	List<FlightModel> getFlightDetailByPilotLicenseNumber(String pilotLicenseNumber);
	
}
