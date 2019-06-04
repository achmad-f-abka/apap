package com.apap.TA.repository;

import java.util.Optional;

import com.apap.TA.model.LabSuppliesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FlightDb
 */

@Repository
public interface StokLabDb extends JpaRepository<LabSuppliesModel, Long> {
	Optional<LabSuppliesModel> findByNamaBarang(String namaBarang);
}	

