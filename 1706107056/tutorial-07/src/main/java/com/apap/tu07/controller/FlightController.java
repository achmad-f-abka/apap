package com.apap.tu07.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tu07.model.FlightModel;
import com.apap.tu07.model.PilotModel;
import com.apap.tu07.service.FlightService;
import com.apap.tu07.service.PilotService;

/**
 * FlightController
 */
@RestController
@RequestMapping("/flight")

public class FlightController {
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private PilotService pilotService;

//    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
//    private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
//        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber).get();
//        pilot.setListFlight(new ArrayList<FlightModel>(){
//            private ArrayList<FlightModel> init(){
//                this.add(new FlightModel());
//                return this;
//            }
//        }.init());
//
//        model.addAttribute("pilot", pilot);
//        return "add-flight";
//    }
    
    @PostMapping(value="/add")
	public FlightModel addFlight(@RequestBody FlightModel flight, Model model){
		return flightService.addFlight(flight);
	}

    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST, params={"addRow"})
    private String addRow(@ModelAttribute PilotModel pilot, Model model) {
        pilot.getListFlight().add(new FlightModel());
        model.addAttribute("pilot", pilot);
        return "add-flight";
    }

    @RequestMapping(value="/flight/add/{licenseNumber}", method = RequestMethod.POST, params={"removeRow"})
    public String removeRow(@ModelAttribute PilotModel pilot, Model model, HttpServletRequest req) {
        Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        pilot.getListFlight().remove(rowId.intValue());
        
        model.addAttribute("pilot", pilot);
        return "add-flight";
    }

    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST, params={"save"})
    private String addFlightSubmit(@ModelAttribute PilotModel pilot) {
        PilotModel archive = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber()).get();
        for (FlightModel flight : pilot.getListFlight()) {
            if (flight != null) {
                flight.setPilot(archive);
                flightService.addFlight(flight);
            }
        }
        return "add";
    }

    @GetMapping(value = "/view/{flightNumber}")
    private FlightModel flightView(@PathVariable("flightNumber") String flightNumber) {
        FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber).get();
        return flight;
    }
    
    @GetMapping(value = "/all")
    private List<FlightModel> flightViewAll(@ModelAttribute FlightModel flight) {
        return flightService.getAllFlight();
    }

//    @RequestMapping(value = "/flight/view", method = RequestMethod.GET)
//    private @ResponseBody FlightModel view(@RequestParam(value = "flightNumber") String flightNumber, Model model) {
//        FlightModel archive = flightService.getFlightDetailByFlightNumber(flightNumber).get();
//        return archive;
//    }

    @DeleteMapping(value = "/delete/{flightId}")
    private String deleteFlight(@PathVariable("flightId") long flightId) {
        FlightModel flight = flightService.getFlightDetailById(flightId).get();
        flightService.deleteFlight(flightId, flight);
        return "flight has been deleted";
    }
    
//    @RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
//    private String delete(@ModelAttribute PilotModel pilot, Model model) {
//        for (FlightModel flight : pilot.getListFlight()) {
//            flightService.deleteByFlightNumber(flight.getFlightNumber());
//        }
//        return "delete";
//    }
    
    
    @PutMapping(value = "/update/{flightId}")
	public String updateFlight(@PathVariable("flightId") long flightId,
			@RequestParam("destination") String destination,
    		@RequestParam("origin") String origin,
    		@RequestParam("time") Date time) {
		FlightModel flight= flightService.getFlightDetailById(flightId).get();
		if (flight.equals(null)) {
			return "Couldn't find your pilot";
		}
		
		flight.setDestination(destination);
        flight.setOrigin(origin);
        flight.setTime(time);
        flightService.updateFlight(flightId, flight);
		return "flight update success";
	}

//    @RequestMapping(value = "/flight/update", method = RequestMethod.GET)
//    private String update(@RequestParam(value = "flightNumber") String flightNumber, Model model) {
//        FlightModel archive = flightService.getFlightDetailByFlightNumber(flightNumber).get();
//        model.addAttribute("flight", archive);
//        return "update-flight";
//    }

//    @RequestMapping(value = "/flight/update", method = RequestMethod.POST)
//    private @ResponseBody FlightModel updateFlightSubmit(@ModelAttribute FlightModel flight, Model model) {
//        flightService.addFlight(flight);
//        return flight;
//    }
}