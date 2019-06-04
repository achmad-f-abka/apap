package com.apap.rscs.service;

import java.util.List;
import java.util.Optional;

import com.apap.rscs.model.PemeriksaanModel;;

public interface PemeriksaanService {
	PemeriksaanModel addPemeriksaan(PemeriksaanModel labSupplies);
	List<PemeriksaanModel> getAllPemeriksaan();
	PemeriksaanModel getById(int id);
	Optional<PemeriksaanModel> getPemeriksaanById(int id);
	void update (PemeriksaanModel permintaanPemeriksaan);
}
