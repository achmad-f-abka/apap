package com.apap.TA.service;

import com.apap.TA.model.JenisPemeriksaanModel;

import java.util.List;
import java.util.Optional;

public interface JenisPemeriksaanService {

	JenisPemeriksaanModel addJenis(JenisPemeriksaanModel jenis);

	List<JenisPemeriksaanModel> getAllJenis();

	Optional<JenisPemeriksaanModel> getDetail(Long id);
}
