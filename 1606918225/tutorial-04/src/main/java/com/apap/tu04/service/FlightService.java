package com.apap.tu04.service;

import java.util.List;
import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;

/**
* 
* FlightService  *
*/
public interface FlightService {
	void addFlight (FlightModel flight);
	List<FlightModel> getFlightListByPilot (PilotModel pilot);
	void deleteFlight (long id);
	List<FlightModel> getAllFlightList();

}
