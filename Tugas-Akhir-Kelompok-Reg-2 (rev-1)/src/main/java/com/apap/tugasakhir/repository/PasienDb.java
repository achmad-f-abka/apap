package com.apap.tugasakhir.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.model.PasienModel;

public interface PasienDb extends JpaRepository <PasienModel, Long>{
	Optional<PasienModel> findById(Long id);
}
