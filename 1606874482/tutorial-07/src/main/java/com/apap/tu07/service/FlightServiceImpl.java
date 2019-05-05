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
	public List<FlightModel> getAllFlight() {
		List<FlightModel> allFlight = flightDb.findAll();
		return allFlight;
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);
	}
	@Override
	public void updateFlight(Long flightId, FlightModel flight) {
		FlightModel update = flightDb.getOne(flightId);
		update.setDestination(flight.getDestination());
		update.setOrigin(flight.getOrigin());
		update.setTime(flight.getTime());
	}
	@Override
	public Optional<FlightModel> getFlightById(long flightId) {
		return flightDb.findById(flightId);
	}

}