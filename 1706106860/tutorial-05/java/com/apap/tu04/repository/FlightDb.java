package com.apap.tu04.repository;

import com.apap.tu04.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDb extends JpaRepository<FlightModel,Long> {
	List <FlightModel> findByPilot(PilotModel pilot);

}
