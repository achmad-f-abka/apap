package com.apap.ta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.PasienModel;

@Repository
public interface PasienDb extends JpaRepository<PasienModel, Integer> {
	
	Optional<PasienModel> findById(int id);
	Optional<PasienModel> findByNama(String nama);

}
