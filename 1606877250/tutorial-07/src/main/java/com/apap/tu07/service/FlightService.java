package com.apap.tu07.service;

import java.util.List;
import java.util.Optional;

import com.apap.tu07.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
    FlightModel addFlight(FlightModel flight);
    
    void deleteByFlightNumber(String flightNumber);
    

    Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber);

	List<FlightModel> getAllFlight();

	Optional<FlightModel> getFlightById(long id);

	void deleteFlight(FlightModel flight);

	void updateFlight(long flightId, FlightModel flight);

}