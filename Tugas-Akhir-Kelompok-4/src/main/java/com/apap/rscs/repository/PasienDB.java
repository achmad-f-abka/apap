package com.apap.rscs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.rscs.model.PasienModel;

@Repository
public interface PasienDB extends JpaRepository<PasienModel, Long>{
	
}
