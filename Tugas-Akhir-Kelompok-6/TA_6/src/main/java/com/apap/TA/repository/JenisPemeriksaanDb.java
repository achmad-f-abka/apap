package com.apap.TA.repository;

import com.apap.TA.model.JenisPemeriksaanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JenisPemeriksaanDb extends JpaRepository<JenisPemeriksaanModel, Long> {
    Optional<JenisPemeriksaanModel> findById(Long id);

}