package com.apap.tu04.service;
import java.util.List;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;


public interface FlightService {
	void addFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void updateFlight(FlightModel flight, String flightNumber);
	void deleteFlight(FlightModel flight);
	List<FlightModel> getFlightList();
}
