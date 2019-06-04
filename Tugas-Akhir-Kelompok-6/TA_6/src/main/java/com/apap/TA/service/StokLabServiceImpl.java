package com.apap.TA.service;


import java.util.List;
import java.util.Optional;

import com.apap.TA.model.LabSuppliesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.TA.repository.StokLabDb;


@Service
@Transactional
public class StokLabServiceImpl implements StokLabService {
	@Autowired
	private StokLabDb stokLabDb;

	@Override
	public LabSuppliesModel addStok(LabSuppliesModel stok) {
		return stokLabDb.save(stok);
	}
	
	@Override
	public List<LabSuppliesModel> getAllStokLab (){
		return stokLabDb.findAll();
	}
	
	@Override
	public Optional<LabSuppliesModel> getDetail (Long id){
		return stokLabDb.findById(id);
	}


}

