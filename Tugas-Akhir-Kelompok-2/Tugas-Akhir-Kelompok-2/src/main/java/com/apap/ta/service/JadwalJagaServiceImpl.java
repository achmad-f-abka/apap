package com.apap.ta.service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.ta.model.JadwalJagaModel;
import com.apap.ta.repository.JadwalJagaDb;

@Service
@Transactional
public class JadwalJagaServiceImpl implements JadwalJagaService {
	
	@Autowired
	private JadwalJagaDb jadwalJagaDb;
	
	@Override
	public JadwalJagaModel addJadwalJaga(JadwalJagaModel jadwalJaga) {
		return jadwalJagaDb.save(jadwalJaga);
	}
	
	@Override
	public void deleteJadwalJagaById(int id) {
		jadwalJagaDb.deleteById(id);
	}
	
	@Override
	public Optional<JadwalJagaModel> getJadwalJagaById(int id){
		return jadwalJagaDb.findById(id);
	}

	@Override
	public List<JadwalJagaModel> getJadwalJagaByTanggal(Date tanggal) {
		return jadwalJagaDb.findByTanggal(tanggal);
	}

	@Override
	public List<JadwalJagaModel> getJadwalJagaList() {
		return jadwalJagaDb.findAll();
	}

}
