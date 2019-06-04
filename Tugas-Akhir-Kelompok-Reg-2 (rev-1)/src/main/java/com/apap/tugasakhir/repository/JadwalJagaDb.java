package com.apap.tugasakhir.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.model.JadwalJagaModel;

public interface JadwalJagaDb extends JpaRepository<JadwalJagaModel, Long>{
	Optional<JadwalJagaModel> findByTanggal(Date date);
}
