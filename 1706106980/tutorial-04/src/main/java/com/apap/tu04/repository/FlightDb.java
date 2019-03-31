package com.apap.tu04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu04.model.FlightModel;

@Repository
public interface FlightDb extends CrudRepository<FlightModel, Long>{
	List<FlightModel> findByPilotLicenseNumber(String pilotLicenseNumber);
}