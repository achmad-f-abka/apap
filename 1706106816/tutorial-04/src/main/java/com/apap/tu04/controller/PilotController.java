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
import com.apap.tu04.service.FlightService;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private FlightService flightService;

	private String licenseNumber;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping (value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilot(Model model ,@RequestParam(value= "licenseNumber") String licenseNumber) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		List<FlightModel> flightList = flightService.getFlightListByPilot(pilot);
		model.addAttribute("pilot", pilot);
		model.addAttribute("flightList", flightList);
		return "view-pilot";
	}
	
	@RequestMapping(value="/pilot/delete/{id}", method = RequestMethod.POST)
	private String deletePilot(@PathVariable (value="id")Long id, Model model) {
		pilotService.deletePilot(id);
		return "deletePilot";
	}
	
	@RequestMapping(value= "/pilot/update/{licenseNumber}", method = RequestMethod.POST)
	public String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		return "update-pilot";	
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
		PilotModel updatedPilot = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
		updatedPilot.setFlyHour(pilot.getFlyHour());
		pilotService.addPilot(updatedPilot);
		return "update";
	}
}
