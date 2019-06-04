package com.apap.rscs.service;

import java.util.List;

import com.apap.rscs.model.PasienModel;

public interface PasienService {
	PasienModel addPasien(PasienModel pasien);
	
	List<PasienModel> getAllPasien();
}
