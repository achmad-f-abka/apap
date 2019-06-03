package com.apap.tugasakhir.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.JenisModel;

public interface JenisPemeriksaanService {
	Optional<JenisModel> getJenisById(Long id);
	List<JenisModel> findAll();
}
