package com.apap.tugasakhir.service;


import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.PemeriksaanModel;

/**
 * FlightService
 */
public interface LabService {
    void addPermintaan(PemeriksaanModel permintaan);
    List<PemeriksaanModel> findAll();
    Optional<PemeriksaanModel> getPemeriksaanById(int id);
}