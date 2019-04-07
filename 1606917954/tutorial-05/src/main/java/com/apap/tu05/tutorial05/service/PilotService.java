package com.apap.tu05.tutorial05.service;

import com.apap.tu05.tutorial05.model.PilotModel;

import java.util.Optional;

public interface PilotService {
    PilotModel getPilotDetailByLicenseNumber(String licenseNumber);

    void addPilot(PilotModel pilot);

    void deletePilot(long id);

    Optional<PilotModel> getPilotById(long id);

}
