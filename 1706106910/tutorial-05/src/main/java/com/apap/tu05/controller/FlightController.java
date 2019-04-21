package com.apap.tu05.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.FlightDb;
import com.apap.tu05.service.FlightService;
import com.apap.tu05.service.FlightServiceImpl;
import com.apap.tu05.service.PilotService;

@Controller
public class FlightController {
	FlightModel flg;
	PilotModel plt;
	List<FlightModel> rowsFlight;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot, Model model) {
		rowsFlight = new ArrayList<FlightModel>();
		FlightModel fl = new FlightModel();
		pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		pilot.setPilotFlight(rowsFlight);
		pilot.getPilotFlight().add(fl);
		model.addAttribute("pilot", pilot);
		return "addFlightDynamic";
	}
	
//	@RequestMapping(value = "/flight/add", method = RequestMethod.POST)
//	private String addFlightSubmit(@ModelAttribute FlightModel flight, @RequestParam("licenseNumber") String licenseNumber, Model model) {
//		flightService.addFlight(flight);
//		model.addAttribute("fNumb", flight.getFlightNumber().toString());
//		model.addAttribute("origin", flight.getOrigin());
//		model.addAttribute("dest", flight.getDestination());
//		model.addAttribute("time", flight.getTime());
//		model.addAttribute("lNumb", licenseNumber);
//		return "addFlightDynam";
//	}
	
	@RequestMapping(value="/flight/add/{licenseNumber}", params = {"addRow"})
	public String addRow(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot, Model model, final BindingResult bindingResult) {
		pilot.getPilotFlight().add(new FlightModel());
		model.addAttribute("pilot", pilot);
	    return "addFlightDynamic";
	}
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", params = {"removeRow"})
	public String removeRow(@PathVariable(value = "licenseNumber") String licenseNumber, @ModelAttribute PilotModel pilot, Model model, final BindingResult bindingResult, final HttpServletRequest req) {
		final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
		pilot.getPilotFlight().remove(rowId.intValue());
		model.addAttribute("pilot", pilot);
		return "addFlightDynamic";
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
	
	@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
    public String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightById(flight.getId());
		}
        return "delete";
    }
	
	
	@RequestMapping(value = "/flight/view/", method = RequestMethod.GET)
    public String viewAll(Model model) {
		model.addAttribute("fList", flightService.getAllFlight());
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
		flg = flightService.getFlightByFlightNumber(flightNumber);
		flg.setOrigin(origin);
		flg.setDestination(destination);
		flg.setTime(time);
		flightService.updateFlight(flg);
		model.addAttribute("fNumb", flightNumber);
		model.addAttribute("origin", flg.getOrigin().toString());
		model.addAttribute("dest", flg.getDestination().toString());
		model.addAttribute("time", flg.getTime().toString());
		return "addFs";
	}

	@RequestMapping(value = "/flight/updates/{flightNumber}", method = RequestMethod.GET)
	private String updateFlights(@PathVariable("flightNumber") String flightNumber, Model model) {
		flg = flightService.getFlightByFlightNumber(flightNumber);
		model.addAttribute("fNumb", flightNumber);
		model.addAttribute("origin", flg.getOrigin().toString());
		model.addAttribute("dest", flg.getDestination().toString());
		model.addAttribute("time", flg.getTime().toString());
		return "update-flights";
	}
	
	@RequestMapping(value = "/flight/detail/{flightNumber}/{licenseNumber}", method = RequestMethod.GET)
	private String detail(@PathVariable(value = "flightNumber") String flightNumber, @PathVariable("licenseNumber") String licenseNumber, Model model) {
		flg = flightService.getFlightByFlightNumber(flightNumber);
		plt = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flg.setPilot(plt);
		model.addAttribute("lNumb", licenseNumber);
		model.addAttribute("name", plt.getName().toString());
		model.addAttribute("fHour", plt.getFlyHour());
		model.addAttribute("fNumb", flightNumber);
		model.addAttribute("ori", flg.getOrigin().toString());
		model.addAttribute("dest", flg.getDestination().toString());
		model.addAttribute("time", flg.getTime());
		if(plt.getFlyHour()>=100) {
			model.addAttribute("status", "Pilot Senior");
		}else {
			model.addAttribute("status", "Pilot Junior");
		}
		return "flight-detail";
	}
}
