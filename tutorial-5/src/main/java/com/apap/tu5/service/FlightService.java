package com.apap.tu5.service;

import java.util.List;

import com.apap.tu5.model.FlightModel;
import com.apap.tu5.model.PilotModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	void deleteFlight(PilotModel pilot, String flightNumber);
	FlightModel getFlight(PilotModel pilot, String flightNumber);
	void updateFlight(FlightModel flight);
}
