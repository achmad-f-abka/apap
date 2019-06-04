package com.apap.TA.service;

import com.apap.TA.model.JenisPemeriksaanModel;
import com.apap.TA.model.PemeriksaanModel;
import com.apap.TA.repository.JenisPemeriksaanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JenisPemeriksaanServiceImpl implements JenisPemeriksaanService {
    @Autowired
    private JenisPemeriksaanDb jenisPemeriksaanModel;


	@Override
	public Optional<JenisPemeriksaanModel> getDetail(Long id) {
		return jenisPemeriksaanModel.findById(id);
	}

	@Override
	public JenisPemeriksaanModel addJenis(JenisPemeriksaanModel jenis) {
		return jenisPemeriksaanModel.save(jenis);
	}

	@Override
	public List<JenisPemeriksaanModel> getAllJenis() {
		return jenisPemeriksaanModel.findAll();
	}
}