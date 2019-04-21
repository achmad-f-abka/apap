package com.apap.tu04.controller;

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

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.repository.FlightDb;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@Autowired
	private FlightDb flighDb;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
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
	
//	@RequestMapping(value = "/flight/view", method = RequestMethod.GET)
//	public String viewAll(Model model, FlightModel flight) {
//		System.out.println("SINI");
//		List<FlightModel> fList = flightService.getAllFlight();
//		model.addAttribute("fList", fList);
//		System.out.println("FUCKZZ "+fList);
//		for(int i=0; i<fList.size(); i++) {
//			System.out.println("ANJING");
//		}
//		return "view-flight";
//	}
	
//	@RequestMapping(value = "/flight/view", method = RequestMethod.GET)
//	public ModelAndView viewAll(Model model, FlightModel flight) {
//		return new ModelAndView("view-flight", "flight", flighDb.findAll());
//	}
	@RequestMapping(value = "/flight/view/", method = RequestMethod.GET)
    public String viewAll(Model model) {
        //return flightService.getAllFlight();
		PilotModel pll = new PilotModel();
		model.addAttribute("fList", flightService.getAllFlight());
        return "view-flight";
    }
	
	
}
