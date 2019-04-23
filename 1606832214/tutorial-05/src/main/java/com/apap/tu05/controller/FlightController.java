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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value= "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pickPilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		ArrayList<FlightModel> pilotFlight = new ArrayList<>();
		pilotFlight.add(flight);
		pickPilot.setPilotFlight(pilotFlight);
		flight.setPilot(pickPilot);
		model.addAttribute("flight", flight);
		model.addAttribute("pickPilot", pickPilot);
		model.addAttribute("title", "Add Flight");
		return "addFlight";
	}
	
	@RequestMapping(value= "/flight/add/{licenseNumber}", params= {"addRow"}, method = RequestMethod.POST)
	private String addRow(@ModelAttribute PilotModel pilot,BindingResult bindingResult, Model model) {
		if(pilot.getPilotFlight() == null) {
			pilot.setPilotFlight(new ArrayList<FlightModel>());
		}
		pilot.getPilotFlight().add(new FlightModel());
		model.addAttribute("pickPilot", pilot);
		return "addFlight";
	}
	
	@RequestMapping(value= "/flight/add/{licenseNumber}", params= {"submitFlight"}, method = RequestMethod.POST)
	private String addaddFlightSubmit(@ModelAttribute PilotModel pilot) {
		PilotModel pickPilot =  pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
		for (FlightModel flight : pilot.getPilotFlight()) {
			flight.setPilot(pickPilot);
			flightService.addFlight(flight);
		}
		return "add";
	}
	
	@RequestMapping(value = "/flight/view/{flightNumber}", method = RequestMethod.GET)
	private String viewFlightSubmit(@PathVariable(value="flightNumber") String flightNumber, Model model){
		FlightModel pickFlight = flightService.getFlightDetailByFlightNumber(flightNumber);
		model.addAttribute("pickFlight", pickFlight);
		return "view-flight";
	}
	
	@RequestMapping (value="/flight/delete", method = RequestMethod.POST)
	private String deleteFlightSubmit(@ModelAttribute PilotModel pickPilot, Model model) {
		for(FlightModel pickFlight : pickPilot.getPilotFlight()) {
			flightService.deleteFlight(pickFlight.getId());
		}
		return "delete-flight";
	}
	
	@RequestMapping (value="/flight/all", method = RequestMethod.GET)
	private String allFlight ( Model model) {
		List <FlightModel> list = flightService.getAllFlightList();
		model.addAttribute ("all", list );
		model.addAttribute("title", "View All Flight");
		return "all-flight";
	}
}

