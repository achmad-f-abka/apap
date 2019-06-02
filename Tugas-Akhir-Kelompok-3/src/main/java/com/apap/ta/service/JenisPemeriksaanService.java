package com.apap.ta.service;

import java.util.Optional;

import com.apap.ta.model.JenisPemeriksaanModel;

public interface JenisPemeriksaanService {
	
	JenisPemeriksaanModel addJenisPemeriksaan(JenisPemeriksaanModel jenisPemeriksaan);
	void deleteJenisPemeriksaanById(int id);
	Optional<JenisPemeriksaanModel> getJenisPemeriksaanById(int id);
	
	

}
