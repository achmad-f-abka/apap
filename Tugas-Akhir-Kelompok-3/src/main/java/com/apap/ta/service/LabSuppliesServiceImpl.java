package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.ta.model.LabSuppliesModel;
import com.apap.ta.repository.LabSuppliesDb;

@Service
@Transactional
public class LabSuppliesServiceImpl implements LabSuppliesService {
	
	@Autowired
	LabSuppliesDb labSuppliesDb;
	

	@Override
	public LabSuppliesModel addSupplies(LabSuppliesModel labSupplies) {
		return labSuppliesDb.save(labSupplies);
	}

	@Override
	public void deleteLabSuppliesById(int id) {
		labSuppliesDb.deleteById(id);
		
	}

	@Override
	public Optional<LabSuppliesModel> getLabSuppliesById(int id) {
		return labSuppliesDb.findById(id);
	}

	@Override
	public List<LabSuppliesModel> getLabSuppliesByJenis(String jenis) {
		return labSuppliesDb.findByJenis(jenis);
	}

	@Override
	public Optional<LabSuppliesModel> getLabSuppliesByNama(String nama) {
		return labSuppliesDb.findByNama(nama);
	}

	@Override
	public List<LabSuppliesModel> getAllSuppliesList() {
		return labSuppliesDb.findAll();
	}
	

}
