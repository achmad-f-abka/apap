package com.apap.tu07.controller;



import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tu07.model.FlightModel;
import com.apap.tu07.model.PilotModel;
import com.apap.tu07.service.FlightService;
import com.apap.tu07.service.PilotService;

/**
 * FlightController add ,update, get flight, get all flight , delete flight
 */
@RestController
@RequestMapping("/flight")
public class FlightController {
  @Autowired 
  private FlightService flightService;
  
  @Autowired
  private PilotService pilotService;
  
  @PostMapping(value = "/add")
  public FlightModel addFlightSubmit(@RequestBody FlightModel flight, @RequestParam("licenseNumber") String licenseNumber) {
  	PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber).get();
  	flight.setPilot(pilot);
  	return flightService.addFlight(flight);
  }
  @GetMapping(value = "/view/{flightNumber}")
  public FlightModel flightView(@PathVariable("flightNumber") String flightNumber) {
  	FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber).get();
  	return flight;
  }
  @GetMapping(value = "/all")
  public List<FlightModel> flightViewAll(Model model) {
  	List<FlightModel> lstFlight = flightService.getAllFlight();
  	return lstFlight;
  			
  }
  
  @DeleteMapping(value="/delete")
  public String deleteFlight(@RequestParam("flightId") long flightId) {
  	FlightModel flight = flightService.getFlightById(flightId).get();
  	flightService.deleteFlight(flight);
  	
  	return "flight has been deleted";
  }
  
  @PutMapping(value = "/update/{flightId}")
  public String updatePilotSubmit(@PathVariable("flightId") long flightId,
  		@RequestParam(value = "destination") String destination,
  		@RequestParam(value = "origin") String origin,
  		@RequestParam(value = "time") Date time) {
  	FlightModel flight = flightService.getFlightById(flightId).get();
  	if (flight.equals(null)) {
  		return "Couldn't find your flight";
  	}
  	flight.setDestination(destination);
  	flight.setOrigin(origin);
  	flight.setTime(time);
  	flightService.updateFlight(flightId, flight);
  	return "flight update success";
  }

}
  