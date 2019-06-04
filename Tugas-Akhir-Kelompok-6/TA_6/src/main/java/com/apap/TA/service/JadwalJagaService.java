package com.apap.TA.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.apap.TA.model.JadwalJagaModel;

public interface JadwalJagaService {
	JadwalJagaModel addJadwal (JadwalJagaModel jadwal);
	//ini buat liat seluruh jadwal tanpa tanggal
	List <JadwalJagaModel> getAllJadwal();
	//ini buat liat seluruh jadwal berdasarkan tanggal
	List <JadwalJagaModel> findByTanggal (Date Tanggal);
	//ini liat seluruh jadwal berdasarkan id 
	Optional <JadwalJagaModel> getJadwalDetail (int id);
	//untuk validatejadwal
	boolean validateJadwal(JadwalJagaModel jadwal);
	

}
