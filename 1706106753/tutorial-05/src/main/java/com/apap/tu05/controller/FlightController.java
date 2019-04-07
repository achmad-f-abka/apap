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
		PilotModel pilot = pilotService.getPilotByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		return "addFlight";
	}

	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}

	@RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.GET)
	private String deleteFlight(@PathVariable(value = "id") Long id) {
		flightService.delete(id);
		return "delete";
	}

	@RequestMapping(value = "/flight/update/{id}", method = RequestMethod.GET)
	private String update(@PathVariable(value = "id") Long id, Model model) {
		FlightModel flight = flightService.getFlightById(id);
		model.addAttribute("flight", flight);
		return "updateFlight";
	}

	@RequestMapping(value = "/flight/update", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel flight) {
		FlightModel updatedFlight = flightService.getFlightById(flight.getId());
		updatedFlight.setDestination(flight.getDestination());
		updatedFlight.setOrigin(flight.getOrigin());
		updatedFlight.setTime(flight.getTime());
		flightService.update(updatedFlight);
		return "update";
	}

	@RequestMapping(value = "/flight/all", method = RequestMethod.GET)
	private String allFlight(Model model) {
		List<FlightModel> allFlight = flightService.getAllFlight();
		model.addAttribute("allFlight", allFlight);
		return "allFlight";
	}

}
