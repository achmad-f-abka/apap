package com.apap.tu05.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

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
	List<FlightModel> rowsFlight;
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
/*	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		model.addAttribute("page", "Add Flight");
		return "addFlight";
	}
 * 
 */
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot, Model model) {
		rowsFlight = new ArrayList<FlightModel>();
		FlightModel fl = new FlightModel();
		pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		pilot.setPilotFlight(rowsFlight);
		pilot.getPilotFlight().add(fl);
		model.addAttribute("pilot", pilot);
		model.addAttribute("page", "Add Flight");
		return "addFlights";
	}
	
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight, Model model) {
		flightService.addFlight(flight);
		model.addAttribute("page", "Add Flight");
		return "add";
	}
	
	@RequestMapping(value= "/flight/view")
	public String viewPilotId(Model model) {
		List<FlightModel> flight = flightService.getAllFlight();
		model.addAttribute("flight", flight);
		model.addAttribute("page", "View Flights");
		return "view-flight.html";	
	}
	
/*	@RequestMapping(value= "/flight/delete/{licenseNumber}/{flightNumber}", method = RequestMethod.GET)
	public String deleteFlight(@PathVariable(value = "licenseNumber") String licenseNumber,
							@PathVariable(value = "flightNumber") String flightNumber, Model model) {
			PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
			flightService.deleteFlight(pilot, flightNumber);
			model.addAttribute("page", "Delete Flight");
			return "delete-info.html";
	}
 * 
 */
	
	@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightById(flight.getId());
		}
		return "delete-info";
	}
		
	@RequestMapping(value= "/flight/update/{licenseNumber}/{flightNumber}", method = RequestMethod.GET)
	public String updateFlight(@PathVariable(value = "licenseNumber") String licenseNumber,
							@PathVariable(value = "flightNumber") String flightNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		FlightModel flight = flightService.getFlight(pilot, flightNumber);
		model.addAttribute("flight", flight);
		model.addAttribute("pilot", pilot);
		model.addAttribute("page", "Update Flight");
		return "update-flight.html";	
	}
	
	@RequestMapping(value = "/flight/update", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel flight, Long id, Model model) {
		flightService.updateFlight(flight);
		model.addAttribute("page", "Update Flight");
		return "update-info.html";
	}
	
	@RequestMapping(value="/flight/add/{licenseNumber}", params = {"addRow"})
	public String addRow(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot, Model model, final BindingResult bindingResult) {
		pilot.getPilotFlight().add(new FlightModel());
		model.addAttribute("pilot", pilot);
		model.addAttribute("page", "Add Flight");
	    return "addFlights";
	}
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", params = {"removeRow"})
	public String removeRow(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot, Model model, final BindingResult bindingResult, final HttpServletRequest req) {
		final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
		pilot.getPilotFlight().remove(rowId.intValue());
		model.addAttribute("pilot", pilot);
		return "addFlights";
	}
	
    @RequestMapping(value="/flight/add/{licenseNumber}", params = {"save"}, method=RequestMethod.POST)
    public String saveFlight(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute FlightModel flight, @ModelAttribute PilotModel pilot, Model model) {
        PilotModel plt = new PilotModel();
    	plt = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
    	rowsFlight = pilot.getPilotFlight();
        
		for(int i= 0; i < rowsFlight.size(); i++) {
			rowsFlight.get(i).setPilot(plt);
			flightService.addFlight(rowsFlight.get(i));
		}
        model.addAttribute("pilot", pilot);
        return "redirect:/pilot/view?licenseNumber={licenseNumber}";
    }
}