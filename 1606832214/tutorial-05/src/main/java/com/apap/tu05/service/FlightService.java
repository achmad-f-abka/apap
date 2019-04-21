package com.apap.tu05.service;

import java.util.List;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;

public interface FlightService {
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	void addFlight(FlightModel flight);
	List<FlightModel> getFlightListByPilot(PilotModel pilot);
	void deleteFlight(Long flightId);
	List<FlightModel> getAllFlightList();
}
