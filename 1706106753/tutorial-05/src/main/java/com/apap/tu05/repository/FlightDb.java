package com.apap.tu05.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu05.model.FlightModel;

@Repository
public interface FlightDb extends CrudRepository<FlightModel, Long>{
	List<FlightModel> findByPilotLicenseNumber(String pilotLicenseNumber);
}
