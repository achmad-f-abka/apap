package com.apap.ta.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.ta.model.JenisPemeriksaanModel;
import com.apap.ta.repository.JenisPemeriksaanDb;

@Service
@Transactional
public class JenisPemeriksaanServiceImpl implements JenisPemeriksaanService {
	
	@Autowired
	private JenisPemeriksaanDb jenisPemeriksaanDb;

	@Override
	public JenisPemeriksaanModel addJenisPemeriksaan(JenisPemeriksaanModel jenisPemeriksaan) {
		return jenisPemeriksaanDb.save(jenisPemeriksaan);
	}

	@Override
	public void deleteJenisPemeriksaanById(int id) {
		jenisPemeriksaanDb.deleteById(id);
		
	}

	@Override
	public Optional<JenisPemeriksaanModel> getJenisPemeriksaanById(int id) {
		return jenisPemeriksaanDb.findById(id);
	}

}
