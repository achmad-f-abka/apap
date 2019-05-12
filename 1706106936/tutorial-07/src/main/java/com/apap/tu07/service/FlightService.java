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
    Optional<FlightModel> getFlightDetailById(long id);
    void deleteFlight(FlightModel flight);
    Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber);
    public List<FlightModel> getAllFlight();
    void updateFlight(long flightId,FlightModel flight);
}