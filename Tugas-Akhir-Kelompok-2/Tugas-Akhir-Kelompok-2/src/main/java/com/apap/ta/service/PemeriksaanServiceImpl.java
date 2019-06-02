package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.ta.model.PemeriksaanModel;
import com.apap.ta.repository.PemeriksaanDb;

@Service
@Transactional
public class PemeriksaanServiceImpl implements PemeriksaanService {
	
	@Autowired
	PemeriksaanDb pemeriksaanDb;

	@Override
	public PemeriksaanModel addPemeriksaan(PemeriksaanModel pemeriksaan) {
		return pemeriksaanDb.save(pemeriksaan);
	}

	@Override
	public void deletePemeriksaanById(int id) {
		pemeriksaanDb.deleteById(id);
		
	}

	@Override
	public Optional<PemeriksaanModel> getPemeriksaanById(int id) {
		return pemeriksaanDb.findById(id);
	}

	@Override
	public List<PemeriksaanModel> getPemeriksaanList() {
		return pemeriksaanDb.findAll();
		
	}

}
