package com.apap.tu05.service;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.PilotDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PilotServiceImpl
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotDb pilotDb;

    @Override
    public PilotModel getPilotDetailBylicenseNumber(String licenseNumber) {
        return pilotDb.findBylicenseNumber(licenseNumber);
    }

    @Override
    public void addPilot(PilotModel pilot) {
        pilotDb.save(pilot);
    }

    // Latihan 3
    // Fitur Delete
    @Override
    public void deletePilot(Long id) {
        pilotDb.deleteById(id);
    }

    // Latihan 4
    // Fitur Update
    @Override
    public void updatePilot(PilotModel pilot, String licenseNumber) {
        PilotModel updatePilot = pilotDb.findBylicenseNumber(licenseNumber);
        updatePilot.setName(pilot.getName());
        updatePilot.setFlyHour(pilot.getFlyHour());
        pilotDb.save(updatePilot);
    }

}