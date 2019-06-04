package com.apap.rscs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.rscs.model.PasienModel;
import com.apap.rscs.repository.PasienDB;

@Service
public class PasienImpl implements PasienService{
	@Autowired
	private PasienDB pasienDb;
	
	@Override
	public PasienModel addPasien(PasienModel pasien) {
		return pasienDb.save(pasien);
	}
	
	@Override
	public List<PasienModel> getAllPasien() {
		List<PasienModel> listPasien = (List<PasienModel>) pasienDb.findAll();
		return listPasien;
	}
}
