package com.apap.tu05.service;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;

/**
 * FlightService
 */

public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlightbyId(long id);

}
