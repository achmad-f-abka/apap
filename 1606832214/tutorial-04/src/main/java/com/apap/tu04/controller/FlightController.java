package com.apap.tu04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value= "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping (value="/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit (@ModelAttribute  FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	@RequestMapping (value="/flight/delete/{id}", method = RequestMethod.POST)
	private String deleteFlightSubmit(@PathVariable (value = "id") Long flightId, Model model) {
		flightService.deleteFlight(flightId);
		return "delete-flight";
	}
	
	@RequestMapping (value="/flight/all", method = RequestMethod.GET)
	private String allFlight ( Model model) {
		List <FlightModel> list = flightService.getAllFlightList();
		model.addAttribute ("all", list );
		return "all-flight";
	}
}
