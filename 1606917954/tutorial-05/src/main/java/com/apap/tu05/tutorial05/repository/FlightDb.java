package com.apap.tu05.tutorial05.repository;

import com.apap.tu05.tutorial05.model.FlightModel;
import com.apap.tu05.tutorial05.model.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
    List<FlightModel> findByPilot(PilotModel pilot);

}
