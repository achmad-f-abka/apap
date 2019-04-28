package com.apap.tu04.controller;

import java.util.List;

import org.aspectj.weaver.NewFieldTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;

/**
 * FlightController
 */
@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber")String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);

		model.addAttribute("pilot", pilot);
		model.addAttribute("flight", flight);
		return "addFlight2";
	}
	
	@RequestMapping(value="/flight/add/{licenseNumber}", params={"addRow"}, method = RequestMethod.POST)
	public String addRow(@PathVariable(value = "licenseNumber") String licenseNumber,
			@ModelAttribute PilotModel pilot, Model model) {
	    
		pilot.getPilotFlight().add(new FlightModel());
	    model.addAttribute("pilot", pilot);
	    return "addFlight2";
	}	
	
	
	/*
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
	
		List<FlightModel> flightList = new ArrayList<>();
		flightList.add(new FlightModel());
		pilot.setPilotFlight(flightList);
		model.addAttribute("pilot", pilot);
		model.addAttribute("title", "Add flights");
		return "addFlight";
	}
	*/
	/*@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight, Model model) {
		flightService.addFlight(flight);
		model.addAttribute("title", "Add flights");
		return "add";
	}*/
	
	@RequestMapping(value="/flight/add/{licenseNumber}", params= {"submit"}, method=RequestMethod.POST)
	public String addFlightSubmit(@ModelAttribute PilotModel pilot) {
		PilotModel curr = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
		List<FlightModel> flights = pilot.getPilotFlight();
		for(int i= 0; i < flights.size(); i++) {
			flights.get(i).setPilot(curr);
			flightService.addFlight(flights.get(i));
		}
		
		return "add";
	}
	
	/*
	 * @RequestMapping(value="/flight/add/{licenseNumber}", params= {"addRow"},
	 * method=RequestMethod.POST) private String addRow(@ModelAttribute PilotModel
	 * pilot, Model model) { pilot.getPilotFlight().add(new FlightModel());
	 * model.addAttribute("pilot", pilot); return "addFlight"; }
	 */
	/*
	@RequestMapping(value="/flight/add/{licenseNumber}",method=RequestMethod.POST, params={"addRow"})
	private String addRow(@PathVariable(value="licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilotTemp, Model model) {
		model.addAttribute("navTitle", "Add Flight");
		
		FlightModel flight = new FlightModel();
		pilotTemp.getPilotFlight().add(flight);
		
		model.addAttribute("licenseNumber", licenseNumber);
		model.addAttribute("pilotTemp", pilotTemp);
		return "addFlight";
	}*/	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		System.out.println(flight.getFlightNumber()+ " " + flight.getPilot().getLicenseNumber());
		flightService.addFlight(flight);
		return "add";
	}
	
//	@RequestMapping(value="/flight/view")
//	private String viewFlight(@RequestParam(value = "flightNumber")String flightNumber, Model model) {
//		FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
//		model.addAttribute("flight", flight);
//		return "view-flight";
//	}
	
	@RequestMapping("/flight/view")
	public String viewAll(Model model) {
		List<FlightModel> flightList = flightService.getFlightList();
		model.addAttribute("flightList", flightList);
		return "view-flight";
	}
	
//	@RequestMapping(value="/flight/delete/{id}")
//	private String deleteFlight(@PathVariable(value = "id") long id) {
//		flightService.deleteFlight(id);
//		return "delete-flight";
//	}
	
	@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightbyId(flight.getId());
		}
		return "delete";
	}


	
//	@RequestMapping(value = "/flight/update", method = RequestMethod.GET)
//	private String updateFlight(@RequestParam long id, Model model) {
//		FlightModel flight = flightService.findById(id);
//		model.addAttribute("flight", flight);
//		return "update-flight";
//	}
//	
	@RequestMapping(value="/flight/update/{licenseNumber}", method = RequestMethod.POST)
	private String UpdateFlightSubmit(@PathVariable(value="licenseNumber") String licenseNumber, @ModelAttribute FlightModel updatedFlight) {
		System.out.println(licenseNumber);
		//System.out.println(">>>>>>" + updatedFlight.getId());
		FlightModel flight = flightService.getFlightDetailByFlightNumber(licenseNumber);
		//FlightModel flight = flightService.findById(updatedFlight.getId());
		//flightService.deleteFlight(updatedFlight.getId());
		flight.setFlightNumber(updatedFlight.getFlightNumber());
		flight.setOrigin(updatedFlight.getOrigin());
		flight.setDestination(updatedFlight.getDestination());
		flight.setTime(updatedFlight.getTime());
		flightService.addFlight(flight);
		return "update-success";
		
	}
	
	@RequestMapping (value = "/flight/update/{id}", method = RequestMethod.GET)
	private String updateFlight (@PathVariable (value = "id") long id, Model model) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + id);
		FlightModel currentFlight = flightService.getFlight(id);		
		//System.out.println(currentFlight);
		String licenseNumbernya = currentFlight.getPilot().getLicenseNumber();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(currentFlight.getPilot().getLicenseNumber()); 
		currentFlight.setPilot(pilot);
		model.addAttribute("flight", currentFlight); 
		return "update-flight"; 
		//return "home";
	}
	
	/*
	 * @RequestMapping (value = "/flight/update", method = RequestMethod.POST)
	 * private String updateFlightSubmit (@ModelAttribute FlightModel currentflight)
	 * { flightService.addFlight(currentflight); return "update-success"; }
	 */
}
