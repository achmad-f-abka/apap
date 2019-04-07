package com.apap.tu04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;

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
	private String addFlightSubmit (@ModelAttribute  FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	@RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.POST)
	private String deleteFlight(@PathVariable(value="id") Long id, Model model) {
		flightService.deleteFlight(id);
		model.addAttribute("title","Delete Flight");
		return"delete";
	}
	@RequestMapping(value= "/flight/viewall", method = RequestMethod.GET)
	private String viewFlight(Model model) {
		List<FlightModel> myFlight = flightService.viewAllFlight();
		model.addAttribute("flight", myFlight);
		model.addAttribute("title", "All Flight");
		return "allFlight";
	}
	/**
	 * tidak bisa mengupdate lewat flight karena merupakan relasi partial 
	 */
	/**@RequestMapping(value = "/flight/update/{id}", method = RequestMethod.POST)
	private String updateFlight(@PathVariable(value="id") Long id,Model model) {
		FlightModel flight =flightService.getFlightDetailById(id).get();
		model.addAttribute("flight", flight);
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
	*/
}
