package com.apap.TA.service;

import com.apap.TA.model.PasienModel;
import com.apap.TA.model.PemeriksaanModel;
import com.apap.TA.repository.PasienDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PasienServiceImpl implements PasienService {
    @Autowired
    private PasienDb pasienModel;

    @Override
	public PasienModel addPasien(PasienModel pasien) {
		return pasienModel.save(pasien);
	}

	@Override
	public List<PasienModel> getAllPasien() {
		return pasienModel.findAll();
	}

	@Override
	public Optional<PasienModel> getDetail(Long id) {
		return pasienModel.findById(id);
	}
}