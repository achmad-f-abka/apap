package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.ta.model.PasienModel;
import com.apap.ta.repository.PasienDb;

@Service
@Transactional
public class PasienServiceImpl implements PasienService {
	
	@Autowired
	private PasienDb pasienDb;

	@Override
	public PasienModel addPasien(PasienModel pasien) {
		return pasienDb.save(pasien);
	}

	@Override
	public void deletePasienModelById(int id) {
		pasienDb.deleteById(id);
		
	}

	@Override
	public Optional<PasienModel> getPasienById(int id) {
		return pasienDb.findById(id);
	}

	@Override
	public Optional<PasienModel> getPasienByNama(String nama) {
		return pasienDb.findByNama(nama);
		
	}

	@Override
	public List<PasienModel> getPasientList() {
		return pasienDb.findAll();
	}

}
