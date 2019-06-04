package com.apap.rscs.service;

import java.util.List;

import com.apap.rscs.model.LabSuppliesModel;

public interface LabSuppliesService {
	LabSuppliesModel getSuppliesById(Long id);
	LabSuppliesModel addLabSupplies(LabSuppliesModel labSupplies);
	List<LabSuppliesModel> getAllSupplies();
	LabSuppliesModel getById(long id);
	void update (LabSuppliesModel labSupplies);
}
