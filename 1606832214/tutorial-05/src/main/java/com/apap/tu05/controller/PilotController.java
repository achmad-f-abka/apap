package com.apap.tu05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.FlightService;
import com.apap.tu05.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilotSubmit(@RequestParam("licenseNumber") String licenseNumber, Model model){
		PilotModel pickPilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		List<FlightModel> listFlight = flightService.getFlightListByPilot(pickPilot);
		model.addAttribute("flightList", listFlight);
		model.addAttribute("pickPilot", pickPilot);
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method = RequestMethod.POST)
	private String deletePilotSubmit(@PathVariable (value = "licenseNumber") String licenseNumber, Model model){
		PilotModel pickPilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pickPilot", pickPilot);
		pilotService.deletePilot(pickPilot);
		return "delete-pilot";
	}
	
	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.POST)
	private String updatePilot(@PathVariable (value = "licenseNumber") String licenseNumber, Model model){
		PilotModel pickPilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pickPilot", pickPilot);
		return "update-pilot";
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "update";
	}
}

