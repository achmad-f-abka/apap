package com.apap.tu04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apap.tu04.FlightModel;
import org.springframework.stereotype.Repository;
/**
 * FlightDb
 */
@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long>{
	FlightModel findByFlightNumber(String flightNumber);

	void save(com.apap.tu04.model.FlightModel flight);
	
}
