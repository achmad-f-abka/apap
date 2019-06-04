package com.apap.TA.service;

import java.util.List;
import java.util.Optional;

import com.apap.TA.model.LabSuppliesModel;

public interface StokLabService {

	LabSuppliesModel addStok(LabSuppliesModel stok);

	List<LabSuppliesModel> getAllStokLab();

	Optional<LabSuppliesModel> getDetail(Long id);

}
