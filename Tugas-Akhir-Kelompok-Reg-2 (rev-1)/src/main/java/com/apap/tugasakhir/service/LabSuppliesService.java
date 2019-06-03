package com.apap.tugasakhir.service;

import java.util.Optional;
import java.util.List;
import java.util.HashMap;

import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.model.KebutuhanReagenModel;

public interface LabSuppliesService {
	void addSupplies(LabSuppliesModel labSupplies);
	List<LabSuppliesModel> getListLabSupplies();
	HashMap<String, Integer> getNumOnSupplies(List<LabSuppliesModel> allLabSupplies);
	Optional<LabSuppliesModel> findLabSuppliesDetailById (int idSuppies);
	void updateLabSupplies(int id, LabSuppliesModel labSupplies);
}
