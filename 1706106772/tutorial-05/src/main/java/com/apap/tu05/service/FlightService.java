package com.apap.tu05.service;

import java.util.List;
import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	FlightModel getFlightByFlightNumber(String flightNumber);
	void updateFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	List<FlightModel> getFlightListByPilot(PilotModel plt);
}
