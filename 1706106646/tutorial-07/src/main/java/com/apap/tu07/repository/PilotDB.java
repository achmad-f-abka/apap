package com.apap.tu07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu07.model.PilotModel;

@Repository
public interface PilotDB extends JpaRepository<PilotModel, Long>{
PilotModel findByLicenseNumber(String licenseNumber);
PilotModel findById(long id);
}
