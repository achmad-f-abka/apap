package com.apap.TA.repository;

import com.apap.TA.model.KebutuhanReagenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KebutuhanReagenDb extends JpaRepository<KebutuhanReagenModel, Long> {
    Optional<KebutuhanReagenModel> findById(Long id);

}
