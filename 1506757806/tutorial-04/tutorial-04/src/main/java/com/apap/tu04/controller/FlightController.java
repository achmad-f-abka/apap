package com.apap.tu04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;

/**
 * FlightController
 */
@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber")String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		System.out.println(flight.getFlightNumber()+ " " + flight.getPilot().getLicenseNumber());
		flightService.addFlight(flight);
		return "add";
	}
	
//	@RequestMapping(value="/flight/view")
//	private String viewFlight(@RequestParam(value = "flightNumber")String flightNumber, Model model) {
//		FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
//		model.addAttribute("flight", flight);
//		return "view-flight";
//	}
	
	@RequestMapping("/flight/view")
	public String viewAll(Model model) {
		List<FlightModel> flightList = flightService.getFlightList();
		model.addAttribute("flightList", flightList);
		return "view-flight";
	}
	
	@RequestMapping(value="/flight/delete/{id}")
	private String deleteFlight(@PathVariable(value = "id") long id) {
		flightService.deleteFlight(id);
		return "delete-flight";
	}
	
}
