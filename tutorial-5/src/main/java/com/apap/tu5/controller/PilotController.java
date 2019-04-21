package com.apap.tu5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu5.model.FlightModel;
import com.apap.tu5.model.PilotModel;
import com.apap.tu5.service.FlightService;
import com.apap.tu5.service.PilotService;

@Controller
public class PilotController {

	@Autowired
	private PilotService pilotService;
	private FlightService flightService;

	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("halaman", "APAP");
		return "home";
	}

	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("halaman", "Add Pilot");
		return "addPilot";
	}


	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("halaman", "Add Pilot");
		return "add";
	}

	@RequestMapping(value= "/pilot/viewAll")
	public String viewAllPilot(Model m) {
		List<PilotModel> pilot = pilotService.getAllPilot();
		m.addAttribute("pilot", pilot);
		m.addAttribute("halaman", "View All Pilot");
		return "view-all-pilot.html";	
	}

	@RequestMapping(value= "/pilot/view", method = RequestMethod.GET)
	public String viewPilotId(@RequestParam(value = "licenseNumber", required = true) String licenseNumber, Model m) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		if (pilot != null) {
			List<FlightModel> flight = pilot.getPilotFlight();
			m.addAttribute("pilot", pilot);
			m.addAttribute("flight", flight);
			m.addAttribute("halaman", "View Pilot");
			return "view-pilot.html";	
		} else {
			return "error-1.html";
		}

	}

	@RequestMapping(value= "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	public String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
			try {
			PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
			pilotService.deletePilot(pilot);
			model.addAttribute("halaman", "Delete License Number");
			return "delete-info.html";	
			} catch (Exception e) {
				return "error-messsage.html";
			}

	}

	@RequestMapping(value= "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	public String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		model.addAttribute("halaman", "Update License Number");
		return "update-pilot.html";	
	}

	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute PilotModel pilot, Long id, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("halaman", "Update License Number");
		return "update-info.html";
	}

	public FlightService getFlightService() {
		return flightService;
	}

	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}
}