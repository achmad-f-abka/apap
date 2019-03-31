package com.apap.tu04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.PilotService;

@Controller
public class PilotController {

	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "Home";
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
	
	@RequestMapping(value = "/pilot/view")
	private String viewPilot(@RequestParam(value="LicenseNumber") String LicenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(LicenseNumber);
		model.addAttribute("pilot",pilot);
		model.addAttribute("flights",pilot.getPilotFlight());
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		pilotService.deletePilot(pilot);
		return "delete-success";
	}
	
	@RequestMapping(value="/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	private String updatePilot(@PathVariable(value = "licenseNumber")String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		return "update-pilot";
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.updatePilot(pilot, pilot.getLicenseNumber());
		return "update-success";
	}
	
	
	
}
