package com.apap.rscs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.rscs.model.KebutuhanReagenModel;

@Repository
public interface KebutuhanReagenDB extends JpaRepository<KebutuhanReagenModel, Long>{
	
}
