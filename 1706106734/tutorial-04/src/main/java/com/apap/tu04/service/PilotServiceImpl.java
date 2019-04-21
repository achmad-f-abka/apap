/* Tutorial 04 - Database
 * Nama: Faris Abdurrahman
 * NIM : 1706106734
 */
package com.apap.tu04.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.repository.FlightDb;

/**
 * FlightServiceImpl
 * @author faris.abdurrahman71
 *
 */
@Service
@Transactional
public class PilotServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
}
