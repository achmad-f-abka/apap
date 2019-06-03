package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.PemeriksaanModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabDB extends JpaRepository<PemeriksaanModel, Long> {
    List<PemeriksaanModel> findAll();
    Optional<PemeriksaanModel> findById(int id);
}