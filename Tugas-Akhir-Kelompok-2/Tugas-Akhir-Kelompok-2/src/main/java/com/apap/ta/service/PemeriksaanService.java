package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import com.apap.ta.model.PemeriksaanModel;

public interface PemeriksaanService {
	
	PemeriksaanModel addPemeriksaan(PemeriksaanModel pemeriksaan);
	void deletePemeriksaanById(int id);
	Optional<PemeriksaanModel> getPemeriksaanById(int id);
	List<PemeriksaanModel> getPemeriksaanList();

}
