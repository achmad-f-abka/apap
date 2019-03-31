package com.apap.tu04.service;

import com.apap.tu04.model.PilotModel;

public interface PilotService {
    PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
    void addPilot(PilotModel pilot);
}
