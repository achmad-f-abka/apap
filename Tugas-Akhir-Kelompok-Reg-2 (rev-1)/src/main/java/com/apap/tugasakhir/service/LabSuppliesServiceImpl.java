package com.apap.tugasakhir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.HashMap;

import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.repository.LabSuppliesDb;

@Service
@Transactional
public class LabSuppliesServiceImpl implements LabSuppliesService {
	@Autowired
	private LabSuppliesDb labSuppliesDb;
	
	@Override
	public void addSupplies(LabSuppliesModel labSupplies) {
		labSuppliesDb.save(labSupplies);
	}
	
	@Override
	public List<LabSuppliesModel> getListLabSupplies(){
		return labSuppliesDb.findAll();
	}
	
	@Override
	public HashMap<String, Integer> getNumOnSupplies(List<LabSuppliesModel> allLabSupplies){
		HashMap<String, Integer> suppliesNum = new HashMap<String, Integer>();
		for(LabSuppliesModel labSupplies : allLabSupplies) {
			suppliesNum.put(String.valueOf(labSupplies.getId()), labSuppliesDb.findAll().size());
		}
		return suppliesNum;
	}
	
	@Override
	public Optional<LabSuppliesModel> findLabSuppliesDetailById(int idSupplies){
		return labSuppliesDb.findById(idSupplies);
	}
	
	@Override
	public void updateLabSupplies(int id, LabSuppliesModel labSupplies) {
		LabSuppliesModel supplies = labSuppliesDb.findById(id).get();
		supplies.setJumlah(labSupplies.getJumlah());
		labSuppliesDb.save(supplies);
	}
} 
