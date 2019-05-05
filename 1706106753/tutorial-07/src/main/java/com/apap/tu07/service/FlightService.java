package com.apap.tu07.service;

import java.util.List;
import java.util.Optional;

import com.apap.tu07.model.FlightModel;
import com.apap.tu07.model.PilotModel;

/**
 * FlightService
 */
public interface FlightService {
    FlightModel addFlight(FlightModel flight);
    
    void deleteByFlightNumber(String flightNumber);
    
    Optional<FlightModel> getFlightById (long flightId);

    Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber);
    
    void updateFlight (Long flightId, FlightModel flight);
    
    void deleteFlight (FlightModel flight);
    
    List<FlightModel> getAllFlight();
}