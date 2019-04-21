package com.apap.tu05.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.FlightService;
import com.apap.tu05.service.PilotService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		model.addAttribute("page", "Tambah Flight");
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	
	@RequestMapping(value= "/flight/view")
	public String viewPilotId(Model m) {
		List<FlightModel> flight = flightService.getAllFlight();
		m.addAttribute("flight", flight);
		m.addAttribute("page", "View All Flight");
		return "view-flight.html";	
	}
	
	@RequestMapping(value= "/flight/delete/{licenseNumber}/{flightNumber}", method = RequestMethod.GET)
	public String deleteFlight1(@PathVariable(value = "licenseNumber") String licenseNumber,
							@PathVariable(value = "flightNumber") String flightNumber, Model model) {
			PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
			flightService.deleteFlight(pilot, flightNumber);
			return "delete-info.html";
			
	}
	
	@RequestMapping(value= "/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
			for (FlightModel flight : pilot.getPilotFlight()) {
				flightService.deleteFlightById(flight.getId());
			}
			return "delete-info.html";
			
	}
	
	@RequestMapping(value= "/flight/view/{licenseNumber}/{flightNumber}", method = RequestMethod.GET)
	public String detailFlight(@PathVariable(value = "licenseNumber") String licenseNumber,
			@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		FlightModel flight = flightService.getFlight(pilot, flightNumber);
		model.addAttribute("flight", flight);
		model.addAttribute("pilot", pilot);
		model.addAttribute("page", "Update Flight");
		return "detail-flight.html";
		
	}
	
	@RequestMapping(value= "/flight/update/{licenseNumber}/{flightNumber}", method = RequestMethod.GET)
	public String updateFlight(@PathVariable(value = "licenseNumber") String licenseNumber,
							@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		FlightModel flight = flightService.getFlight(pilot, flightNumber);
		model.addAttribute("flight", flight);
		model.addAttribute("pilot", pilot);
		model.addAttribute("page", "Update Flight");
		return "update-flight.html";
		
	}
	
	@RequestMapping(value = "/flight/update", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel flight, Long id) {
		flightService.updateFlight(flight);
		return "update-info.html";
	}
}
