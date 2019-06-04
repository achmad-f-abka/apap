package com.apap.rscs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.apap.rscs.model.PemeriksaanModel;

@Repository
public interface PemeriksaanDB extends JpaRepository<PemeriksaanModel, Integer> {
	Optional<PemeriksaanModel> findById(int id);
}
