package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.LabSuppliesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LabSuppliesDb extends JpaRepository<LabSuppliesModel, Integer> {
	Optional<LabSuppliesModel> findById (int id);

}
