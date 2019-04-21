/* Tutorial 04 - Database
 * Nama: Faris Abdurrahman
 * NIM : 1706106734
 */
package com.apap.tu04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.PilotDb;

/**
 * PilotServiceImpl
 * @author faris.abdurrahman71
 *
 */

@Service
@Transactional
public class FlightServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}
}
