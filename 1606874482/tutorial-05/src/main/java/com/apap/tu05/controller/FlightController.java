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
		
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		model.addAttribute("title", "Add Flight");
		return "addFlight";
	}

	@RequestMapping (value="/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit (@ModelAttribute  FlightModel flight, Model model) {
		flightService.addFlight(flight);
		model.addAttribute("title", "Added");
		return "add";
	}
	@RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.POST)
	private String deleteFlight(@PathVariable(value="id") Long id, Model model) {
		flightService.deleteFlight(id);
		model.addAttribute("title", "Deleted");
		return"delete";
	}
	@RequestMapping(value= "/flight/viewall", method = RequestMethod.GET)
	private String viewFlight(Model model) {
		List<FlightModel> myFlight = flightService.viewAllFlight();
		model.addAttribute("flight", myFlight);
		model.addAttribute("title", "View All Flight");
		return "allFlight";
	}
	@RequestMapping(value = "/flight/update/{id}", method = RequestMethod.POST)
	private String updateFlight(@PathVariable(value="id") Long id,Model model) {
		FlightModel flight =flightService.getFlightDetailById(id).get();
		model.addAttribute("flight", flight);
		model.addAttribute("title", "Flight Update");
		return "updateFlight";
	}
	@RequestMapping (value="/flight/update", method = RequestMethod.POST)
	private String updateSubmit(@ModelAttribute FlightModel flight) {
		FlightModel real = flightService.getFlightDetailById(flight.getId()).get();
		real.setDestination(flight.getDestination());
		real.setOrigin(flight.getOrigin());
		real.setTime(flight.getTime());
		real.setFlightNumber(flight.getFlightNumber());
		flightService.addFlight(real);
		return "update";
	}
	
}
