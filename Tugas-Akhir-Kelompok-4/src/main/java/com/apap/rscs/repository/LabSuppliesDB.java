package com.apap.rscs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.rscs.model.LabSuppliesModel;

@Repository
public interface LabSuppliesDB extends JpaRepository<LabSuppliesModel, Long>{
    LabSuppliesModel findLabSuppliesById(Long id);
}
