package com.apap.tu05.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		
		/*
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
		*/
		
		@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
		private String add (@PathVariable(value = "licenseNumber")String licenseNumber, Model model) {
			PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
			List<FlightModel> listFlight = new ArrayList<FlightModel>();
			FlightModel flight = new FlightModel();
			listFlight.add(flight);
			pilot.setPilotFlight(listFlight);
			model.addAttribute("pilot", pilot);
			return "addFlight";
		}
		
		
		
		@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST, params={"addFlight"})
		private String addRow(@ModelAttribute PilotModel pilot, Model model) {
		pilot.getPilotFlight().add(new FlightModel());
		model.addAttribute("pilot", pilot);
			return "addFlight";
		}
  

		@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST)
		private String addFlightSubmit(@ModelAttribute PilotModel pilot, Model model) {
		PilotModel pilotget = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
		for (FlightModel flight : pilot.getPilotFlight()) {
			if(flight != null) {
				flight.setPilot(pilotget);
					flightService.addFlight(flight);
				}
			}
			return "add";	
		}
		    
		@RequestMapping("/flight/view")
		public String viewAll(Model model) {
			List<FlightModel> flightList = flightService.getFlightList();
			model.addAttribute("flightList", flightList);
			return "view-flight";
		}
		
		@RequestMapping(value = "/flight/view/{flightNumber}", method = RequestMethod.GET)
		private String detailFlight(@PathVariable(value="flightNumber") String flightNumber, Model model) {
			FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
			model.addAttribute("flight", flight);
			return "view-detail-flight";
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
		
		@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
		private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
			for(FlightModel flight : pilot.getPilotFlight()) {
				flightService.deleteFlightById(flight.getId());
			}
			return "delete-success";
		}

}
