package com.app.tu05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.tu05.model.FlightModel;

@Repository
public interface FlightDb extends JpaRepository<FlightModel,Long>{
	
	FlightModel findByFlightNumber(String flightNumber);
}
