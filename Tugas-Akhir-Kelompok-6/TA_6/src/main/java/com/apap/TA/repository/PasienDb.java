package com.apap.TA.repository;

import com.apap.TA.model.PasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasienDb extends JpaRepository<PasienModel, Long> {
    Optional<PasienModel> findById(Long id);

}