package com.app.tu05.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.tu05.model.FlightModel;
import com.app.tu05.model.PilotModel;
import com.app.tu05.service.FlightService;
import com.app.tu05.service.PilotService;

@Controller
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value="/flight/add/{licenseNumber}",method=RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight",flight);
		return "addFlight";
	}	
	
	@RequestMapping(value="/flight/add",method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	@RequestMapping(value = "/pilot/{licenseNumber}/flight/delete/{flightNumber}", method = RequestMethod.GET)
	private String deleteFlight(@PathVariable(value = "flightNumber") String flightNumber,@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		flightService.deleteFlight(flightNumber);
		PilotModel pilot=pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		return "delete";
	}
	
	@RequestMapping(value = "/pilot/{licenseNumber}/flight/update/{flightNumber}", method = RequestMethod.GET)
	private String updateFlight(@PathVariable (value="licenseNumber") String licenseNumber,@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		FlightModel flightLama = flightService.getFlightDetailByFlightNumber(flightNumber);
		PilotModel pilot=pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("flightLama", flightLama);
		model.addAttribute("pilot", pilot);
		model.addAttribute("flightBaru", new FlightModel());
		return "updateFlight";
	}
	
	@RequestMapping(value = "pilot/{licenseNumber}/flight/update/{flightNumber}", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel flightBaru, @PathVariable (value="licenseNumber") String licenseNumber, @PathVariable(value = "flightNumber") String flightNumber, Model model) {
		flightService.updateFlight(flightNumber, flightBaru);
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("newPilot",pilot);
		return "update";
	}
	

	@RequestMapping(value = "/listFlights", method = RequestMethod.GET)
	private String listFlights(Model model) {
		List<FlightModel> penerbangan = flightService.getAllFlight();
		model.addAttribute("flight", penerbangan);
		return "listFlight";
	}
	
	@RequestMapping(value = "/flight/view/{flightNumber}", method = RequestMethod.GET)
	private String viewFlights(@PathVariable(value="flightNumber") String flightNumber,Model model) {
		FlightModel flight=flightService.getFlightDetailByFlightNumber(flightNumber);
		model.addAttribute("flight", flight);
		return "detailFlight";
	}

}
