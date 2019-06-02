package com.apap.ta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.PemeriksaanModel;

@Repository
public interface PemeriksaanDb extends JpaRepository<PemeriksaanModel, Integer> {
	
	Optional<PemeriksaanModel> findById(int id);

}
