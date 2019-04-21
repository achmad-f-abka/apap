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

import com.apap.tu05.service.PilotService;
import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;

@Controller
public class PilotController {
	
	@Autowired
	private PilotService pilotService;
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
	
	@RequestMapping(value= "/pilot/viewAll")
	public String viewAllPilot(Model m) {
		List<PilotModel> pilot = pilotService.getAllPilot();
		m.addAttribute("pilot", pilot);
		return "view-all-pilot.html";	
	}
	
	@RequestMapping(value= "/pilot/view", method = RequestMethod.GET)
	public String viewPilotId(@RequestParam(value = "licenseNumber", required = true) String licenseNumber, Model m) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		if (pilot != null) {
			List<FlightModel> flight = pilot.getPilotFlight();
			m.addAttribute("pilot", pilot);
			m.addAttribute("flight", flight);
			return "view-pilot.html";	
		} else {
			return "error-1.html";
		}
		
	}
	
	@RequestMapping(value= "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	public String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
			try {
			PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
			pilotService.deletePilot(pilot);
			return "delete-info.html";	
			} catch (Exception e) {
				return "error-messsage.html";
			}
		
	}
	
	@RequestMapping(value= "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	public String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		return "update-pilot.html";	
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute PilotModel pilot, Long id) {
		pilotService.addPilot(pilot);
		return "update-info.html";
	}
}
