package com.apap.tu07.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu07.model.FlightModel;

/**
 * FlightDb
 */
@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
    void deleteByFlightNumber(String flightNumber);

    Optional<FlightModel> findByFlightNumber(String flightNumber);
    
    Optional<FlightModel> findById(long id);
}