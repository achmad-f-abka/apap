package com.apap.tugasakhir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.PasienModel;
import com.apap.tugasakhir.repository.PasienDb;

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
	public List<PasienModel> getAllPasien() {
		return pasienDb.findAll();
	}

	@Override
	public Optional<PasienModel> getPasienById(Long id) {
		return pasienDb.findById(id);
	}
}
