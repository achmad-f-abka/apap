package com.apap.tu05.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;

@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
	void deleteByPilotAndFlightNumber(PilotModel pilot, String flightNumber);
	FlightModel findByPilotAndFlightNumber(PilotModel pilot, String flightNUmber);
	void deleteFlightById(long id);
}
