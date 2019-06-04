package com.apap.TA.service;

import com.apap.TA.model.PemeriksaanModel;
import com.apap.TA.repository.PemeriksaanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PemeriksaanServiceImpl implements PemeriksaanService {
    @Autowired
    private PemeriksaanDb periksaModel;

	@Override
	public PemeriksaanModel addJadwal(PemeriksaanModel jadwal) {
		return periksaModel.save(jadwal);
	}

	@Override
	public List<PemeriksaanModel> getAllJadwal() {
		return periksaModel.findAll();
	}

	@Override
	public Optional<PemeriksaanModel> getDetail(Long id) {
		return periksaModel.findById(id);
	}
}