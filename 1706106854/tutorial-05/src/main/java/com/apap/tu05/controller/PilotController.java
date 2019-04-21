package com.apap.tu05.controller;


import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.PilotService;
import com.apap.tu05.model.FlightModel;
import com.apap.tu05.service.FlightService;

@Controller
public class PilotController {
	
	@Autowired
	private PilotService pilotService;
	private FlightService flightService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("page", "APAP");
		return "home";
	}
	
	@RequestMapping("/jet")
	private String viewFlight(Model model) {
		model.addAttribute("page", "404");
		return "404";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("page", "Add Pilot");
		return "addPilot";
	}
	
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("page", "Add Pilot");
		return "add";
	}
	
	@RequestMapping(value= "/pilot/viewAll")
	public String viewAllPilot(Model model) {
		List<PilotModel> pilot = pilotService.getAllPilot();
		model.addAttribute("pilot", pilot);
		model.addAttribute("page", "View Pilots");
		return "view-all-pilot.html";	
	}


//	@RequestMapping(value= "/pilot/view", method = RequestMethod.GET)
//	public String viewPilotId(@RequestParam(value = "licenseNumber", required = true) String licenseNumber, Model model) {
//		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
//		if (pilot != null) {
//			List<FlightModel> flight = pilot.getPilotFlight();
//			model.addAttribute("pilot", pilot);
//			model.addAttribute("flight", flight);
//			model.addAttribute("page", "View Pilot");
//			return "view-pilot";	
//		} else {
//			model.addAttribute("page", "Error");
//			return "error-1";
//		}
//		
//	}

	@RequestMapping(value= "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	public String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
			try {
			PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
			pilotService.deletePilot(pilot);
			model.addAttribute("page", "Delete Pilot");
			return "delete-info.html";	
			} catch (Exception e) {
				model.addAttribute("page", "Error");
				return "error-messsage.html";
			}
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	public String viewPilot(@RequestParam(value="licenseNumber") String licenseNumber, Model model) {
			PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
			model.addAttribute("pilot", pilot);
			return "view-pilot";
	}
	
	@RequestMapping(value= "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	public String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		model.addAttribute("page", "Update Pilot");
		return "update-pilot.html";	
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute PilotModel pilot, Long id, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("page", "Update Flight");
		return "update-info.html";
	}
}
