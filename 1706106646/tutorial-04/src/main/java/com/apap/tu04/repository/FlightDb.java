package com.apap.tu04.repository;

import com.apap.tu04.model.FlightModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FlightDb
 */
@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long>{
    FlightModel findByFlightNumber(String flightNumber); // not used list in flight number

    FlightModel findFlightById(Long id); // Latihan 4 Created for Service Imp;
}