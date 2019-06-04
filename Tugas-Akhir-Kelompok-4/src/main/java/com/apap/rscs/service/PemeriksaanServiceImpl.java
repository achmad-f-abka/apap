package com.apap.rscs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.rscs.model.PemeriksaanModel;
import com.apap.rscs.repository.PemeriksaanDB;

@Service
@Transactional
public class PemeriksaanServiceImpl implements PemeriksaanService {
	@Autowired
	private PemeriksaanDB pemeriksaanDb;

	@Override
	public List<PemeriksaanModel> getAllPemeriksaan() {
		List<PemeriksaanModel> listPemeriksaan = (List<PemeriksaanModel>) pemeriksaanDb.findAll();
		return listPemeriksaan;
	}
	
	@Override
	public PemeriksaanModel addPemeriksaan(PemeriksaanModel permintaanPemeriksaan) {
		return pemeriksaanDb.save(permintaanPemeriksaan);
	}
	
	@Override
	public void update(PemeriksaanModel permintaanPemeriksaan) {
		pemeriksaanDb.save(permintaanPemeriksaan);
	}
	
	@Override
	public Optional<PemeriksaanModel> getPemeriksaanById(int id) {
		return pemeriksaanDb.findById(id);
	}

	@Override
	public PemeriksaanModel getById(int id) {
		return pemeriksaanDb.getOne(id);
	}

}
