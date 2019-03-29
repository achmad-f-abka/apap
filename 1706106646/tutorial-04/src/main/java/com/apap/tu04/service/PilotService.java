package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;

/**
 * PilotService
 */
public interface PilotService {
    PilotModel getPilotDetailBylicenseNumber(String licenseNumber);
    void addPilot(PilotModel pilot);
    void deletePilot(Long id); // Latihan 3 (Fitur Delete)
    void updatePilot(PilotModel pilot, String licenseNumber); // Latihan 4 (Fitur Update)
}