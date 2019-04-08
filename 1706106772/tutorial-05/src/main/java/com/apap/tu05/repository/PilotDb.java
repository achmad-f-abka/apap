package com.apap.tu05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apap.tu05.model.PilotModel;

public interface PilotDb extends JpaRepository<PilotModel, Long> {
	PilotModel findByLicenseNumber(String licenseNumber);
	void deleteByLicenseNumber(String licenseNumber);
}
