package com.apap.TA.repository;

import com.apap.TA.model.PemeriksaanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PemeriksaanDb extends JpaRepository<PemeriksaanModel, Long> {
    Optional<PemeriksaanModel> findById(Long id);

}