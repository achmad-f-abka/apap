package com.apap.rscs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.rscs.model.LabSuppliesModel;
import com.apap.rscs.repository.LabSuppliesDB;

@Service
@Transactional
public class LabSuppliesImpl implements LabSuppliesService{
	@Autowired
    private LabSuppliesDB labSuppliesDb;

	@Override
	public LabSuppliesModel getSuppliesById(Long id) {
		return labSuppliesDb.getOne(id);
	}

	@Override
	public List<LabSuppliesModel> getAllSupplies() {
		List<LabSuppliesModel> listSupplies = (List<LabSuppliesModel>) labSuppliesDb.findAll();
		return listSupplies;
	}

	@Override
    public LabSuppliesModel addLabSupplies(LabSuppliesModel labSupplies) {
        return labSuppliesDb.save(labSupplies);
	}

	@Override
	public void update(LabSuppliesModel labSupplies) {
		labSuppliesDb.save(labSupplies);
	}

	@Override
	public LabSuppliesModel getById(long id) {
		return labSuppliesDb.getOne(id);
	}
}
