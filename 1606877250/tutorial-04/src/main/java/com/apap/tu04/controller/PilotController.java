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
import com.apap.tu04.service.PilotService;

/**
 * PilotController
 */
@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value="/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value="/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value="/pilot/view")
	private String viewPilot(String licenseNumber, Model model) {
		PilotModel pilots = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		List<FlightModel> flightData = pilots.getPilotFlight();
		model.addAttribute("pilots", pilots);
		model.addAttribute("flights", flightData);
		return "view-pilot";
		
	}
	@RequestMapping(value="/pilot/delete/{licenseNumber}")
	private String deletePilot(@ModelAttribute PilotModel pilot, @PathVariable(value="licenseNumber") String licenseNumber) {
		List<FlightModel> flight = pilot.getPilotFlight();
		for (int i = 0; i <= flight.size()-1; i++) {
			if (flight.get(i).getPilot().getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
				flight.remove(i);
				return "view-pilot";
				
			}
			pilotService.deletePilot(pilot);
		}return "home";
	}

}
