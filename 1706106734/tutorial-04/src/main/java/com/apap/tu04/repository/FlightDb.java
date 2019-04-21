/* Tutorial 04 - Database
 * Nama: Faris Abdurrahman
 * NIM : 1706106734
 */

package com.apap.tu04.repository;

import com.apap.tu04.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author faris.abdurrahman71
 * FlightDb
 */

@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
	FlightModel findByFlightNumber(String flightNumber);
}
