package com.apap.ta.repository;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.JadwalJagaModel;

@Repository
public interface JadwalJagaDb extends JpaRepository<JadwalJagaModel, Integer> {
	
	Optional<JadwalJagaModel> findById(int id);
	List<JadwalJagaModel> findByTanggal(Date tanggal);

}
