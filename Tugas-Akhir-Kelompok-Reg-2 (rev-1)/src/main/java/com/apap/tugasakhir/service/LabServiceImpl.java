package com.apap.tugasakhir.service;

import java.util.List;
import java.util.Optional;


import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.model.PemeriksaanModel;
import com.apap.tugasakhir.repository.LabDB;

@Service
@Transactional

public class LabServiceImpl implements LabService{
	@Autowired
	private LabDB labDB;
	
	@Override
	public void addPermintaan (PemeriksaanModel permintaan) {
		labDB.save(permintaan);
	}
	
	@Override
	public List<PemeriksaanModel> findAll() {
		return labDB.findAll();
	}
	
	@Override
	public Optional<PemeriksaanModel> getPemeriksaanById(int id) {
		return labDB.findById(id);
	}
}
