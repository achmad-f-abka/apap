package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import com.apap.ta.model.PasienModel;

public interface PasienService {
	
	PasienModel addPasien(PasienModel pasien);
	void deletePasienModelById(int id);
	Optional<PasienModel> getPasienById(int id);
	Optional<PasienModel> getPasienByNama(String nama);
	List<PasienModel> getPasientList();

}
