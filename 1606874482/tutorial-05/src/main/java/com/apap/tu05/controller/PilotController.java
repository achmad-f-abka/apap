package com.apap.tu05.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * 
 * PilotController
 *
 */

@Controller

public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/")
	private String home(Model model) {
		System.out.println("test");
		model.addAttribute("title", "APAP");
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add (Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("title", "Tambah Pilot");
		return "addPilot";
	}
	
	@RequestMapping (value = "/pilot/add" , method = RequestMethod.POST)
	private String addPilotSubmit (@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("title", "Added");
		return "add";
	}

/**
 * 	@RequestMapping (value= "/pilot/view/", method = RequestMethod.GET)
 * @param model
 * @param licenseNumber
 * @return
 */
	@RequestMapping (value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilot(Model model ,@RequestParam(value= "licenseNumber") String licenseNumber) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		List<FlightModel> flight = flightService.getFlightListByPilot(pilot);
		model.addAttribute("pilot", pilot);
		model.addAttribute("allFlight", flight);
		model.addAttribute("title", "Pilot View");
		return "viewPilot";
	}
	@RequestMapping(value="/pilot/delete/{id}", method = RequestMethod.POST)
	private String deletePilot(@PathVariable (value="id")Long id, Model model) {
		pilotService.deletePilot(id);
		model.addAttribute("title", "Deleted");
		return "delete";
	}
	@RequestMapping (value="/pilot/update/{id}", method = RequestMethod.POST)
	private String updatePilot (@PathVariable (value = "id") Long id, Model model) {
		 PilotModel pilot = pilotService.getPilotDetailById(id).get();
		 model.addAttribute("pilot", pilot);
		 model.addAttribute("title", "Update Pilot");
		 return "updatePilot";
	}
	
	@RequestMapping (value = "/pilot/update" , method = RequestMethod.POST)
	private String pilotSubmit (@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("title", "Updated");
		return "update";
	}	

	
}

