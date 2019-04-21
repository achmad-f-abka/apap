package com.apap.tu5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu5.model.PilotModel;

@Repository
public interface PilotDb extends JpaRepository<PilotModel, Long> {
	PilotModel findByLicenseNumber(String licenseNumber);

}