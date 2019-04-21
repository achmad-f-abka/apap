package com.apap.tu04.service;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.repository.FlightDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;


    @Override
    public void addFlight(FlightModel flight) {
        flightDb.save(flight);
    }
}
