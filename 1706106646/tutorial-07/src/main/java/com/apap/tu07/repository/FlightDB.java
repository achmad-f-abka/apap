package com.apap.tu07.repository;

import com.apap.tu07.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long> {
}