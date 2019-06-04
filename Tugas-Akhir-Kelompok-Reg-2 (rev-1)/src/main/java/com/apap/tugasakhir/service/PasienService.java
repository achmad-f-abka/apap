package com.apap.tugasakhir.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.PasienModel;

public interface PasienService {
	PasienModel addPasien(PasienModel pasien);
	Optional<PasienModel> getPasienById(Long id);
	List<PasienModel> getAllPasien();
}
