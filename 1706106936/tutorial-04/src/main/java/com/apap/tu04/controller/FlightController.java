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

@Controller
public class FlightController {
		@Autowired
		private FlightService flightService;
		
		@Autowired
		private PilotService pilotService;
		
		@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
		private String add (@PathVariable(value = "licenseNumber")String licenseNumber, Model model) {
			FlightModel flight = new FlightModel();
			PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
			flight.setPilot(pilot);
			model.addAttribute("flight", flight);
			return "addFlight";
		}
		
		@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
		private String addFlightSubmit(@ModelAttribute FlightModel flight) {
			flightService.addFlight(flight);
			return "add";	
		}
		@RequestMapping("/flight/view")
		public String viewAll(Model model) {
			List<FlightModel> flightList = flightService.getFlightList();
			model.addAttribute("flightList", flightList);
			return "view-flight";
		}
		
		@RequestMapping(value = "/flight/delete/{flightNumber}", method = RequestMethod.GET)
		private String deleteFlight(@PathVariable(value = "flightNumber") String flightNumber) {
			FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
			flightService.deleteFlight(flight);
			return "delete-success";
		}
		
		@RequestMapping(value="/flight/update/{flightNumber}", method = RequestMethod.GET)
		private String updateFlight(@PathVariable(value = "flightNumber")String flightNumber, Model model) {
			FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
			model.addAttribute("flight", flight);
			return "update-flight";
		}
		
		@RequestMapping(value = "/flight/update", method = RequestMethod.POST)
		private String updateFlightSubmit(@ModelAttribute FlightModel flight) {
			flightService.updateFlight(flight, flight.getFlightNumber());
			return "update-success";
		}

}
