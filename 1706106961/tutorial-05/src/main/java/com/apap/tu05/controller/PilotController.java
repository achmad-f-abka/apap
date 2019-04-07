package com.apap.tu05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("pageTitle","Home");
		return "home";
	}
	
	@RequestMapping(value="/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pageTitle","Add Pilot");
		model.addAttribute("pilot",new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
		model.addAttribute("pageTitle","Pilot Added");
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view/{licenseNumber}", method = RequestMethod.GET)
	private String viewPilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		if(pilot == null) {
			model.addAttribute("pageTitle","License Not Found");
			return "license-notfound";
		}
		model.addAttribute("pageTitle","View Pilot");
		model.addAttribute("pilot", pilot);
		model.addAttribute("listFlight", pilot.getPilotFlight());
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilotDelete = pilotService.getPilotDetailByLicenseNumber(licenseNumber); 
		if(pilotDelete.getPilotFlight().size() ==0) {
			pilotService.deletePilot(licenseNumber);
		}else {
			pilotDelete.getPilotFlight().clear();
			pilotService.deletePilot(licenseNumber);
		}
		model.addAttribute("pageTitle","Delete Pilot");
		return "delete";
	}
	
	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	private String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilotLama = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilotLama", pilotLama);
		model.addAttribute("pilotBaru", new PilotModel());
		model.addAttribute("pageTitle","Update Pilot");
		return "updatePilot";
	}
	
	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.POST)
	private String updatePilot(@ModelAttribute PilotModel pilotBaru, @PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		pilotService.updatePilot(licenseNumber, pilotBaru);
		model.addAttribute("pageTitle","Pilot Updated");
		return "update";
	}
}
