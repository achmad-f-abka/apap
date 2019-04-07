package com.apap.tu05.controller;

import java.util.List;
import java.util.Optional;

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

/**
 * 
 * PilotController
 *
 */

@Controller

public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/")
	private String home(Model model) {
		System.out.println("test");
		model.addAttribute("title", "APAP");
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add (Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("title", "Add Pilot");
		return "addPilot";
	}
	
	@RequestMapping (value = "/pilot/add" , method = RequestMethod.POST)
	private String addPilotSubmit (@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("title", "Success");
		return "add";
	}

/**
 * 	@RequestMapping (value= "/pilot/view/", method = RequestMethod.GET)
 * @param model
 * @param licenseNumber
 * @return
 */
	@RequestMapping (value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilot(Model model ,@RequestParam(value= "licenseNumber") String licenseNumber) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		List<FlightModel> flight = flightService.getFlightListByPilot(pilot);
		model.addAttribute("pilot", pilot);
		model.addAttribute("allFlight", flight);
		model.addAttribute("title", "View Pilot");
		return "view-pilot";
	}
	@RequestMapping(value="/pilot/delete/{id}", method = RequestMethod.POST)
	private String deletePilot(@PathVariable (value="id")Long id, Model model) {
		pilotService.deletePilot(id);
		model.addAttribute("title", "Delete Pilot");
		return "delete";
	}
	
	@RequestMapping(value="/pilot/update/{id}", method = RequestMethod.GET)
	private String updatePilot(@PathVariable Long id, Model model) {
		PilotModel pilot = pilotService.getPilotDetailById(id).get();
		model.addAttribute("pilot", pilot);
		model.addAttribute("newPilot", new PilotModel());
		model.addAttribute("title", "Update Pilot");
		return "updatePilot";
	}
	@RequestMapping(value="/pilot/update/{id}", method = RequestMethod.POST)
	private String updatePilot(@PathVariable Long id, @ModelAttribute PilotModel newPilot) {
		pilotService.updatePilot(id, newPilot);
		return "update";
	}
}