package com.apap.tu07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu07.model.FlightModel;
import com.apap.tu07.repository.FlightDb;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;
    
    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
    public void deleteByFlightNumber(String flightNumber) {
        flightDb.deleteByFlightNumber(flightNumber);
    }

    @Override
    public Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber) {
        return flightDb.findByFlightNumber(flightNumber);
    }
    
    @Override 
    public Optional<FlightModel> getFlightDetailById(long id){
    	return flightDb.findById(id);
    	
    }
    
    @Override
    public void deleteFlight(FlightModel flight) {
    	flightDb.delete(flight);
    }
    
    @Override
    public List<FlightModel> getAllFlight(){
    	return flightDb.findAll();
    }
    
    @Override
    public void updateFlight (long flightId,FlightModel flight) {
    	FlightModel flightData = flightDb.findById(flightId).get();
    	flightData.setDestination(flight.getDestination());
    	flightData.setOrigin(flight.getOrigin());
    	flightData.setTime(flight.getTime());
    	flightDb.save(flightData);
    }
}