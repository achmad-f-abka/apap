package com.apap.tu05.repository;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * FlightDb *
 */

@Repository
public interface FlightDb extends JpaRepository <FlightModel , Long> {
	List <FlightModel> findByPilot (PilotModel pilot);
}