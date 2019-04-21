package com.apap.tu05.controller;

import java.io.Serializable;
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
import org.springframework.*;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.PilotService;
import com.apap.tu05.model.FlightModel;
import com.apap.tu05.service.FlightService;



@Controller
public class PilotController implements Serializable{
	@Autowired
	private PilotService pilotService;
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("title", "Home");
		return "Home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("title", "Add Pilot");
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit (@ModelAttribute PilotModel pilot, Model model) {
//		pilotService.addPilot(pilot);
		model.addAttribute("titile", "Pilot berhasil ditambahkan");
		return "add";
	}
	
	
	@RequestMapping (value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilot (@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
//		List <FlightModel> listFlight = flightService.getFlightListByPilot(pilot);
		model.addAttribute("pilot", pilot);
//		model.addAttribute("flightlist", listFlight);
//		model.addAttribute("title", "View Pilot");
		return "view-pilot";
	}
	
	@RequestMapping (value="/pilot/delete/{id}", method = RequestMethod.POST)
	private String deletePilot (@PathVariable (value = "id") Long pilotid, Model model) {
		pilotService.deletePilot(pilotid);
		model.addAttribute("title", "Delete Pilot");
		return "delete";
	}
	
	@RequestMapping (value="/pilot/update/{id}", method = RequestMethod.POST)
	private String updatePilot (@PathVariable (value = "id") Long pilotid, Model model) {
		 PilotModel pilot = pilotService.getPilotById(pilotid).get();
		 model.addAttribute("pilot", pilot);
		 model.addAttribute("title", "Update Pilot");
		 return "update-pilot";
	}
	
	@RequestMapping (value = "/pilot/update" , method = RequestMethod.POST)
	private String updatePilotSubmit (@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("title", "Pilot berhasil dihapus");
		return "update";
	}	

}