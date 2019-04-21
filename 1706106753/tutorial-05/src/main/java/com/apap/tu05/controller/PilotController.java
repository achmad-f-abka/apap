package com.apap.tu05.controller;

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
import com.apap.tu05.repository.PilotDb;
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
	
	@RequestMapping(value="/pilot/view", method = RequestMethod.GET)
	private String viewPilot(Model model, @RequestParam("licenseNumber") String licenseNumber) {
		System.out.println("hasil :"+licenseNumber);
		model.addAttribute("detailPilot", pilotService.getPilotByLicenseNumber(licenseNumber));
		System.out.println("hasil"+ flightService.getPilotByLicenseNumber(licenseNumber));
		
		model.addAttribute("listFlights", flightService.getPilotByLicenseNumber(licenseNumber));
		return "view-pilot";
		//return "add";
	}
	
	@RequestMapping(value="/pilot/delete/{id}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable(value="id") Long id) {
		pilotService.delete(id);
		return "delete";
	}
	
	@RequestMapping(value="/pilot/update/{id}", method = RequestMethod.GET)
	private String update(@PathVariable(value="id") Long id, Model model) {
		PilotModel pilot = pilotService.getPilotById(id);
		model.addAttribute("pilot", pilot);
		return "updatePilot";
	}
	
	@RequestMapping(value="/pilot/update", method = RequestMethod.POST)
	private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
		PilotModel updatedPilot = pilotService.getPilotById(pilot.getId());
		updatedPilot.setFlyHour(pilot.getFlyHour());
		updatedPilot.setName(pilot.getName());
		pilotService.update(updatedPilot);
		return "update";
	}
	
	
}
