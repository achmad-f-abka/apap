package com.apap.tu05.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.FlightDb;
import com.apap.tu05.service.FlightService;
import com.apap.tu05.service.PilotService;

@Controller
public class FlightController {
	FlightModel fm;
	PilotModel pm;
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private FlightDb flightDb;
	
	@RequestMapping(value="/flight/add/{licenseNumber}",method=RequestMethod.GET)
	private String add(@PathVariable(value="licenseNumber")String licenseNumber, Model model) {
		FlightModel flight= new FlightModel();
		PilotModel pilot= pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("license_number", licenseNumber);
		model.addAttribute("flight",flight);
		return "addFlight";
	}
	
	@RequestMapping(value="/flight/add", method=RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight, @RequestParam("licenseNumber") String licenseNumber, Model model) {
			flightService.addFlight(flight);
			model.addAttribute("fNo",flight.getFlightNumber().toString());
			model.addAttribute("origin", flight.getOrigin());
			model.addAttribute("destination", flight.getDestination());
			model.addAttribute("time", flight.getTime());
			model.addAttribute("licenseNumber", licenseNumber);
			return "add-flight";
	}
	@RequestMapping(value = "/flight/view/", method = RequestMethod.GET)
    public String viewAll(Model model) {
		model.addAttribute("flightList", flightService.getAllFlight());
		model.addAttribute("found", true);
        return "view-flight";
    }
	@RequestMapping(value = "/flight/updates/", method = RequestMethod.POST)
	public String updateFlightSubmits(@RequestParam("flightNumber") String flightNumber,
			@RequestParam(value = "origin", required = true) String origin,
			@RequestParam(value = "destination", required = true) String destination,
			@RequestParam(value = "time", required = true) Date time,
			@ModelAttribute FlightModel flight,
			Model model) {
		 fm = flightService.getFlightByFlightNumber(flightNumber);
		fm.setOrigin(origin);
		fm.setDestination(destination);
		fm.setTime(time);
		flightService.updateFlight(fm);
		model.addAttribute("fNo", flightNumber);
		model.addAttribute("origin", fm.getOrigin().toString());
		model.addAttribute("destination", fm.getDestination().toString());
		model.addAttribute("time", fm.getTime().toString());
		return "addFlights";
	}
	@RequestMapping(value = "/flight/updates/{flightNumber}", method = RequestMethod.GET)
	private String updateFlights(@PathVariable("flightNumber") String flightNumber, Model model) {
		 fm = flightService.getFlightByFlightNumber(flightNumber);
		model.addAttribute("fNo", flightNumber);
		model.addAttribute("origin", fm.getOrigin().toString());
		model.addAttribute("destination", fm.getDestination().toString());
		model.addAttribute("time", fm.getTime().toString());
		return "update-flights";
	}
	@RequestMapping(value = "/flight/detail/{flightNumber}/{licenseNumber}", method = RequestMethod.GET)
	private String detail(@PathVariable(value = "flightNumber") String flightNumber, @PathVariable("licenseNumber") String licenseNumber, Model model) {
		 fm = flightService.getFlightByFlightNumber(flightNumber);
		 pm = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		fm.setPilot(pm);
		model.addAttribute("lNumb", licenseNumber);
		model.addAttribute("name", pm.getName().toString());
		model.addAttribute("fHour", pm.getFlyHour());
		model.addAttribute("fNo", flightNumber);
		model.addAttribute("origin", fm.getOrigin().toString());
		model.addAttribute("destintion", fm.getDestination().toString());
		model.addAttribute("time", fm.getTime());
		if(pm.getFlyHour()>=100) {
			model.addAttribute("status", "Pilot Senior");
		}else {
			model.addAttribute("status", "Pilot Junior");
		}
		return "flight-detail";
	}

	

	


}
