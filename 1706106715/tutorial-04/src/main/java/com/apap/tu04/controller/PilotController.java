package com.apap.tu04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.PilotService;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.service.FlightService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private PilotService flightService;
	
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
	
}
