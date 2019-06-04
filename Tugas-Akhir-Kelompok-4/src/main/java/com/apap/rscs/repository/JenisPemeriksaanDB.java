package com.apap.rscs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.rscs.model.JenisPemeriksaanModel;

@Repository
public interface JenisPemeriksaanDB extends JpaRepository<JenisPemeriksaanModel, Long> {

}
