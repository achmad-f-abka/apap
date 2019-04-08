package com.apap.tu05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class PilotController {
	PilotModel pm;
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/")
	private String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}

	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("lNo", pilot.getLicenseNumber().toString());
		model.addAttribute("name", pilot.getName().toString());
		model.addAttribute("fHour", pilot.getFlyHour());
		return "add";
	}
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		pm = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		//if(pm != null) {
			List<FlightModel> lFlight = flightService.getFlightListByPilot(pm);
			model.addAttribute("license_number", pm.getLicenseNumber().toString());
			FlightModel flight = new FlightModel();
			PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
			flight.setPilot(pilot);
			model.addAttribute("name", pm.getName().toString());
			model.addAttribute("fly_hour", pm.getFlyHour());
			model.addAttribute("found", pm);
			model.addAttribute("flightList", lFlight);
		//}
		return "view-pilot";
	}
	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	public String deletePilot(@PathVariable("licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot) {
		pm = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		if (pm == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND).toString();
		}
		pilotService.deletePilot(licenseNumber);
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/update/", method = RequestMethod.POST)
	public String updatePilotSubmit(@RequestParam("licenseNumber") String licenseNumber,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "fly_hour", required = true) int fly_hour, Model model) {
		pm = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		//if (pm != null) {
			pm.setName(name);
			pm.setFlyHour(fly_hour);
			pilotService.updatePilot(pm);

			List<FlightModel> lFlight = flightService.getFlightListByPilot(pm);
			model.addAttribute("license_number", pm.getLicenseNumber().toString());
			model.addAttribute("name", pm.getName().toString());
			model.addAttribute("fly_hour", pm.getFlyHour());
			model.addAttribute("found", pm);
			model.addAttribute("flightList", lFlight);
			return "view-pilot";
		//}
		//return new ResponseEntity(HttpStatus.NOT_FOUND).toString();
	}

	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	private String updatePilot(@PathVariable("licenseNumber") String licenseNumber, Model model) {
		pm = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("license_number", pm.getLicenseNumber().toString());
		model.addAttribute("name", pm.getName().toString());
		model.addAttribute("flyHour", pm.getFlyHour());
		model.addAttribute("found", pm);
		return "update-pilot";
	}

	@RequestMapping(value = "/pilot/updates/", method = RequestMethod.POST)
	public String updatePilotSubmits(@RequestParam("licenseNumber") String licenseNumber,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "flyHour", required = true) int fly_hour,
			@ModelAttribute PilotModel pilot,
			Model model) {
		pm = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		pm.setName(name);
		pm.setFlyHour(fly_hour);
		pilotService.updatePilot(pm);
		model.addAttribute("lNo", licenseNumber);
		model.addAttribute("name", pm.getName().toString());
		model.addAttribute("fHour", pm.getFlyHour());
		return "add-pilot";
	}

	@RequestMapping(value = "/pilot/updates/{licenseNumber}", method = RequestMethod.GET)
	private String updatePilots(@PathVariable("licenseNumber") String licenseNumber, Model model) {
		pm = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		if(pm != null) {
			model.addAttribute("license_number", pm.getLicenseNumber().toString());
			model.addAttribute("name", pm.getName().toString());
			model.addAttribute("flyHour", pm.getFlyHour());
			model.addAttribute("up", pm);
		}
		return "update-pilots";
	}

}
