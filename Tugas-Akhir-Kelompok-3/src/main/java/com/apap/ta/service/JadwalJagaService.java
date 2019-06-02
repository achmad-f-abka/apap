package com.apap.ta.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.apap.ta.model.JadwalJagaModel;

public interface JadwalJagaService {
	
	JadwalJagaModel addJadwalJaga(JadwalJagaModel jadwalJaga);
	
	void deleteJadwalJagaById (int id);
	
	Optional<JadwalJagaModel> getJadwalJagaById(int id);
	List<JadwalJagaModel> getJadwalJagaByTgl(Date tanggal);
	
	
}
