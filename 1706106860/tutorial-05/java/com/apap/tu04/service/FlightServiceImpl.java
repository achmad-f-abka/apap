package com.apap.tu04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu04.model.*;
import com.apap.tu04.repository.*;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	
	public List<FlightModel> getFLightListByPilot(PilotModel pilot){
		List<FlightModel> listFlight =flightDb.findByPilot(pilot);
		return listFlight;
	}
	
	
	public List<FlightModel> getAllFlightList(){
		List<FlightModel> listFlight =flightDb.findAll();
		return listFlight;
	}

	@Override
	public void deleteFlight(Long flightid) {
		flightDb.deleteById(flightid);
		
	}

	@Override
	public List<FlightModel> getFlightListByPilot(PilotModel pilot) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
