/* Tutorial 04 - Database
 * Nama: Faris Abdurrahman
 * NIM : 1706106734
 */

package com.apap.tu04.repository;

import com.apap.tu04.model.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author faris.abdurrahman71
 * PilotDb
 */

@Repository
public interface PilotDb extends JpaRepository<PilotModel, Long> {
	PilotModel findByLicenseNumber(String licenseNumber);
}
