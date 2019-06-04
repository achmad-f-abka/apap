package com.apap.tugasakhir.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.JadwalJagaModel;

public interface JadwalJagaService {
	JadwalJagaModel addJadwal(JadwalJagaModel jadwal);
	
	 Optional<JadwalJagaModel> getJadwalByTanggal(Date date);

	Optional<JadwalJagaModel> getJadwalById(long id);
	
	List<JadwalJagaModel> getJadwalAll();
}
