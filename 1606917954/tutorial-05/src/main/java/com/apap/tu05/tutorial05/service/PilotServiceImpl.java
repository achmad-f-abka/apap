package com.apap.tu05.tutorial05.service;

import com.apap.tu05.tutorial05.model.PilotModel;
import com.apap.tu05.tutorial05.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotDb pilotDb;

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    @Override
    public void addPilot(PilotModel pilot) {
        pilotDb.save(pilot);
    }

    @Override
    public void deletePilot(long id) {
        pilotDb.deleteById(id);

    }

    @Override
    public Optional<PilotModel> getPilotById(long id) {
        return pilotDb.findById(id);

    }

}
