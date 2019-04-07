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
	private String home() {
		System.out.println("test");
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add (Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("title", "Add - New Pilot");
		return "addPilot";
	}
	
	@RequestMapping (value = "/pilot/add" , method = RequestMethod.POST)
	private String addPilotSubmit (@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping (value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilot (Model model , @RequestParam (value = "licenseNumber") String licenseNumber) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		List <FlightModel> listFlight = flightService.getFlightListByPilot(pilot);
		model.addAttribute("pilot", pilot);
		model.addAttribute("flightlist", listFlight);
		model.addAttribute("title", "View - Pilot");
		return "view-pilot";
		
	}
	
	@RequestMapping (value="/pilot/delete/{id}", method = RequestMethod.POST)
	private String deletePilot (@PathVariable (value = "id") Long pilotid, Model model) {
		pilotService.deletePilot(pilotid);
		return "delete";
	}
	
	@RequestMapping (value="/pilot/update/{id}", method = RequestMethod.POST)
	private String updatePilot (@PathVariable (value = "id") Long pilotid, Model model) {
		 PilotModel pilot = pilotService.getPilotById(pilotid).get();
		 model.addAttribute("pilot", pilot);
		 model.addAttribute("title", "Update - Pilot");
		 return "update-pilot";
	}
	
	@RequestMapping (value = "/pilot/update" , method = RequestMethod.POST)
	private String updatePilotSubmit (@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "update";
	}	

}

