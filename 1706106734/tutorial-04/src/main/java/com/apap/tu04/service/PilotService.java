/* Tutorial 04 - Database
 * Nama: Faris Abdurrahman
 * NIM : 1706106734
 */


package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;

/**
 * 
 * @author faris.abdurrahman71
 * Pilot Service
 */
public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	
}
