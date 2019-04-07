package com.apap.tu04.service;

import java.util.List;

import com.apap.tu04.model.*;


public interface FlightService {
	void addFlight(FlightModel flight);

	void deleteFlight(Long flightid);

	List<FlightModel> getAllFlightList();

	List<FlightModel> getFlightListByPilot(PilotModel pilot);

}
