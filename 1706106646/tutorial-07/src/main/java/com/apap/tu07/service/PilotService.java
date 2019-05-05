package com.apap.tu07.service;
import com.apap.tu07.model.PilotModel;


public interface PilotService {
PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
PilotModel getPilotDetailById(long id);
PilotModel addPilot(PilotModel pilot);
void updatePilot(PilotModel pilot);
void removePilot(long pilot);
}
