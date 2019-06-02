package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import com.apap.ta.model.LabSuppliesModel;

public interface LabSuppliesService {
		
		LabSuppliesModel addLabSupplies(LabSuppliesModel labSupplies);
		void deleteLabSuppliesById(int id);
		Optional<LabSuppliesModel> getLabSuppliesById(int id);
		List<LabSuppliesModel> getLabSuppliesByJenis(String jenis);
		Optional<LabSuppliesModel>getLabSuppliesByNama(String nama);
		List<LabSuppliesModel> getAllSuppliesList();

}
