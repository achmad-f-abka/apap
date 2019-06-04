package com.apap.tugasakhir.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.JenisModel;
import com.apap.tugasakhir.repository.JenisPemeriksaanDb;

@Service
@Transactional
public class JenisPemeriksaanServiceImpl implements JenisPemeriksaanService {
	@Autowired
	private JenisPemeriksaanDb jenisDb;

	@Override
	public Optional<JenisModel> getJenisById(Long id) {
		return jenisDb.findById(id);
	}

	@Override
	public List<JenisModel> findAll() {
		return jenisDb.findAll();
	}
}
