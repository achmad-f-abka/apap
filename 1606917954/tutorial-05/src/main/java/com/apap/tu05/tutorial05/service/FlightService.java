package com.apap.tu05.tutorial05.service;

import com.apap.tu05.tutorial05.model.FlightModel;
import com.apap.tu05.tutorial05.model.PilotModel;

import java.util.List;

public interface FlightService {
    void addFlight(FlightModel flight);

    void deleteFlight(long id);

    List<FlightModel> getFlightListByPilot(PilotModel pilot);

    List<FlightModel> getAllFlightList();
}
