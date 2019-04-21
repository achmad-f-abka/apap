package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotDb pilotDb;

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber){
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    @Override
    public void addPilot(PilotModel pilot){
        pilotDb.save(pilot);
    }
}
