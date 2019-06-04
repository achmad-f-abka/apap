package com.apap.rscs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.rscs.model.StaffModel;

@Repository
public interface StaffDB extends JpaRepository<StaffModel, Long>{

}
