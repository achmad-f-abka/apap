package com.apap.tu5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu5.model.FlightModel;
import com.apap.tu5.model.PilotModel;

@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
	void deleteByPilotAndFlightNumber(PilotModel pilot, String flightNumber);
	FlightModel findByPilotAndFlightNumber(PilotModel pilot, String flightNUmber);
}