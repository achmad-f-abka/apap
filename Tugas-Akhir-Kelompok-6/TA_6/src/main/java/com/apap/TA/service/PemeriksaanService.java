package com.apap.TA.service;

import com.apap.TA.model.PemeriksaanModel;

import java.util.List;
import java.util.Optional;

public interface PemeriksaanService {

	PemeriksaanModel addJadwal(PemeriksaanModel jadwal);

	List<PemeriksaanModel> getAllJadwal();

	Optional<PemeriksaanModel> getDetail(Long id);
}