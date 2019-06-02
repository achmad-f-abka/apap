package com.apap.ta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.ta.model.LabSuppliesModel;

@Repository
public interface LabSuppliesDb extends JpaRepository<LabSuppliesModel, Integer> {
	
	Optional<LabSuppliesModel> findById(int id);
	List<LabSuppliesModel> findByJenis(String jenis);
	Optional<LabSuppliesModel> findByNama(String nama);

}
