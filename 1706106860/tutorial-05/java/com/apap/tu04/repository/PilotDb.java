package com.apap.tu04.repository;

import com.apap.tu04.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotDb extends JpaRepository<PilotModel,Long> {
	PilotModel findByLicenseNumber(String licenseNumber);
}
