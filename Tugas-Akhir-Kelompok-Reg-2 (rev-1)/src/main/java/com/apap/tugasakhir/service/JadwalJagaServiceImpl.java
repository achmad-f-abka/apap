package com.apap.tugasakhir.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.JadwalJagaModel;
import com.apap.tugasakhir.repository.JadwalJagaDb;

@Service
@Transactional
public class JadwalJagaServiceImpl implements JadwalJagaService {
	@Autowired
	private JadwalJagaDb jadwalJagaDb;

	@Override
	public JadwalJagaModel addJadwal(JadwalJagaModel jadwal) {
		return jadwalJagaDb.save(jadwal);
	}

	@Override
	public Optional<JadwalJagaModel> getJadwalByTanggal(Date date) {
		return jadwalJagaDb.findByTanggal(date);
	}

	@Override
	public Optional<JadwalJagaModel> getJadwalById(long id) {
		return jadwalJagaDb.findById(id);
	}

	@Override
	public List<JadwalJagaModel> getJadwalAll() {
		System.out.println("hgggggggggggggggggg");
		return jadwalJagaDb.findAll();
	}

	
	

}
