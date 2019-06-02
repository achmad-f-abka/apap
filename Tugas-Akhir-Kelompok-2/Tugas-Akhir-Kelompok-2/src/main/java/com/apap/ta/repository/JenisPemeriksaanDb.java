package com.apap.ta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.JenisPemeriksaanModel;

@Repository
public interface JenisPemeriksaanDb extends JpaRepository<JenisPemeriksaanModel, Integer> {
	
	Optional<JenisPemeriksaanModel> findById(int id);

}
