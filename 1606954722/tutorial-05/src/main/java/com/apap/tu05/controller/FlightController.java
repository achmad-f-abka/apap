package com.apap.tu05.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.FlightService;
import com.apap.tu05.service.PilotService;

/**
 * 
 * FlightController
 *
 */

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value="/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add (@PathVariable(value = "licenseNumber") String licenseNumber,Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		ArrayList<FlightModel> pilotFlight = new ArrayList<>();
		pilotFlight.add(flight);
		pilot.setPilotFlight(pilotFlight);
		
		flight.setPilot(pilot);
		model.addAttribute("pilot", pilot);
		model.addAttribute("flight", flight);
		model.addAttribute("title", "Add Flight");
		return "addFlight";
	}
	
	@RequestMapping(value="/flight/add/{licenseNumber}", method = RequestMethod.POST, params={"addRow"})
	public String addRow(@ModelAttribute PilotModel pilot,BindingResult bindingResult, Model model) {
		if(pilot.getPilotFlight() == null) {
			pilot.setPilotFlight(new ArrayList<FlightModel>());
		}
		
		pilot.getPilotFlight().add(new FlightModel());
		model.addAttribute("pilot", pilot);
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST, params= {"submit"})
	private String addFlightSubmit(@ModelAttribute PilotModel pilot) {
		PilotModel pilotBaru = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
		for (FlightModel flight : pilot.getPilotFlight()) {
			flight.setPilot(pilotBaru);
			flightService.addFlight(flight);
		}
	
		return "add";
	}

//	@RequestMapping (value="/flight/add", method = RequestMethod.POST)
//	private String addFlightSubmit (@ModelAttribute  FlightModel flight) {
//		flightService.addFlight(flight);
//		return "add";
//	}
//	@RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.POST)
//	private String deleteFlight(@PathVariable(value="id") Long id, Model model) {
//		flightService.deleteFlightById(id);
//		model.addAttribute("title", "Delete Flight");
//		return"delete";
//	}
	
	//deleteFlight baru
	@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightById(flight.getId());
		}
		return"delete";
	}
	
	@RequestMapping(value= "/flight/viewall", method = RequestMethod.GET)
	private String viewFlight(Model model) {
		List<FlightModel> flight = flightService.viewAllFlight();
		model.addAttribute("flight",flight);
		model.addAttribute("title", "All Flight");
		return "allFlight";
	}
	@RequestMapping(value = "/flight/update/{id}", method = RequestMethod.GET)
	private String updateFlight(@PathVariable(value="id") Long id,Model model) {
		FlightModel flight =flightService.getFlightDetailById(id).get();
		model.addAttribute("flight", flight);
		model.addAttribute("newFlight", new FlightModel());
		model.addAttribute("title", "Update Flight");
		return "updateFlight";
	}
	@RequestMapping (value="/flight/update/{id}", method = RequestMethod.POST)
	private String updateSubmit(@PathVariable(value="id") Long id, @ModelAttribute FlightModel newFlight) {
		flightService.updateFlight(id, newFlight);
		return "update";
	}
	
}
