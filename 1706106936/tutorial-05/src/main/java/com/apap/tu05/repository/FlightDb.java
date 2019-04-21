package com.apap.tu05.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu05.model.FlightModel;

@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long>{

	FlightModel findByFlightNumber(String flightNumber);
	List<FlightModel> findByPilotLicenseNumber(String PilotLicenseNumber);
	FlightModel findById(long id);

}
