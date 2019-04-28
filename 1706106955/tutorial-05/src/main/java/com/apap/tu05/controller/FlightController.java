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

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;

	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		ArrayList<FlightModel> list = new ArrayList<FlightModel>();
		list.add(new FlightModel());
		pilot.setPilotFlight(list);
		model.addAttribute("pilot", pilot);
		model.addAttribute("title", "Add Flight");
		return "addFlight";
	}
 
	@RequestMapping(value = "/flight/add/{licenseNumber}", params = { "save" }, method = RequestMethod.POST)
	private String addFlightSubmit(Model model, @ModelAttribute PilotModel pilot, @ModelAttribute FlightModel flight) {
		PilotModel jumper = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
		for (FlightModel iterate : pilot.getPilotFlight()) {
			iterate.setPilot(jumper);
			flightService.addFlight(iterate);
			model.addAttribute("title", "Flight Added");
		}
		return "add";
	}

	@RequestMapping(value = "/flight/add/{licenseNumber}", params = { "addRow" })
	public String addRow(@ModelAttribute PilotModel pilot, BindingResult bindingResult, Model model) {
		if (pilot.getPilotFlight() == null) {
			pilot.setPilotFlight(new ArrayList<FlightModel>());
		}
		FlightModel newFlight = new FlightModel();
		pilot.getPilotFlight().add(newFlight);
		model.addAttribute("pilot", pilot);
		model.addAttribute("title", "Add Flight");
		return "addFlight";

	}
	
	@RequestMapping(value = "/flight/view/{flightNumber}", method = RequestMethod.GET)
	private String seeFlight(@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		FlightModel flightModel = flightService.getFlightDetailByFlightNumber(flightNumber);
		model.addAttribute("flightNumber", flightModel.getFlightNumber());
		model.addAttribute("pilot", flightModel.getPilot());
		model.addAttribute("title", "View Flight");
		return "view-flight";
	}
	
	@RequestMapping(value = "/flight/delete/{flightNumber}", method = RequestMethod.GET)
	private String deleteFlight(@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		FlightModel flightDelete = flightService.getFlightDetailByFlightNumber(flightNumber);
		flightService.deleteFlight(flightNumber);
		model.addAttribute("title", "Delete Flight");
		return "delete";
	}
	
	@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightById(flight.getId());
		}
		return "delete";
	}
	
	@RequestMapping(value = "/flight/update{flightNumber}", method = RequestMethod.GET)
	private String updateFlight(@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		FlightModel flightLama = flightService.getFlightDetailByFlightNumber(flightNumber);
		model.addAttribute("flightLama", flightLama);
		model.addAttribute("flightBaru", new FlightModel());
		model.addAttribute("title", "Update Flight");
		return "updateFlight";
	}
	
	@RequestMapping(value = "/flight/update{flightNumber}", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel flightBaru, @PathVariable(value = "flightNumber") String flightNumber, Model model) {
		flightService.updateFlight(flightNumber, flightBaru);
		model.addAttribute("title", "Flight Updated");
		return "update";
	}
	
	@RequestMapping(value = "/flight/viewall", method = RequestMethod.GET)
	private String viewFlights(Model model) {
		List<FlightModel> terbang = flightService.getAllFlight();
		model.addAttribute("flight", terbang);
		model.addAttribute("title", "View All Flight");
		return "listFlight";
	}
}
