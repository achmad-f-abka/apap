package com.apap.TA.service;

import com.apap.TA.model.PasienModel;

import java.util.List;
import java.util.Optional;

public interface PasienService {

	PasienModel addPasien(PasienModel pasien);

	List<PasienModel> getAllPasien();

	Optional<PasienModel> getDetail(Long id);
}