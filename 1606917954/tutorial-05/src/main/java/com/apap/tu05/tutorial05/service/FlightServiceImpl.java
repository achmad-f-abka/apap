package com.apap.tu05.tutorial05.service;

import com.apap.tu05.tutorial05.model.FlightModel;
import com.apap.tu05.tutorial05.model.PilotModel;
import com.apap.tu05.tutorial05.repository.FlightDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;


    @Override
    public void addFlight(FlightModel flight) {
        flightDb.save(flight);
    }

    @Override
    public List<FlightModel> getFlightListByPilot(PilotModel pilot) {
        List<FlightModel> listFlight = flightDb.findByPilot(pilot);
        return listFlight;
    }

    @Override
    public void deleteFlight(long id) {
        flightDb.deleteById(id);

    }

    @Override
    public List<FlightModel> getAllFlightList() {
        List<FlightModel> listFlight = flightDb.findAll();
        return listFlight;

    }
}
