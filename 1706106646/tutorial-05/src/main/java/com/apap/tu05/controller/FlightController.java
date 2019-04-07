package com.apap.tu05.controller;

import java.util.List;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.FlightService;
import com.apap.tu05.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private String add(@PathVariable(value="licenseNumber") String licenseNumber, Model model){
        FlightModel flight = new FlightModel();
        PilotModel pilot = pilotService.getPilotDetailBylicenseNumber(licenseNumber);
        flight.setPilot(pilot);
        model.addAttribute("flight", flight);
        model.addAttribute("title", "Add Flight");
        return "addFlight";
    }

    @RequestMapping(value="/flight/add", method=RequestMethod.POST)
    private String addFlightSubmit(Model model, @ModelAttribute FlightModel flight) {
        flightService.addFlight(flight);
        model.addAttribute("title", "Flight Added");
        return "add";
    }
    
    // Latihan 3
    // Delete Sebuah Penerbangan
    @RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.GET)
    private String delFlight(Model model, @PathVariable(value = "id") Long id) {
        flightService.deleteFlight(id);
        model.addAttribute("title", "Delete Flight");
        return "delete-flight";
    }

    // Latihan 4
    // Update Sebuah Penerbangan
    // Method GET
    // Using delete by id 
    @RequestMapping(value = "/flight/update/{id}", method = RequestMethod.GET)
    private String updatingFlight(@PathVariable(value = "id") Long id, Model model) {
        FlightModel flight = flightService.getFlight(id);
        model.addAttribute("flight", flight);
        model.addAttribute("title", "Update Flight");
        return "update-flight";
    }

    // Latihan 4
    // POST UPDATE
    // Using delete by id
    @RequestMapping(value = "flight/update/{id}", method = RequestMethod.POST)
    private String updatedFlight(Model model, @PathVariable(value = "id") long id, @ModelAttribute FlightModel flights) {
        flightService.updateFlight(id, flights);
        model.addAttribute("title", "Flight Updated");
		return "updated-flight";
    }

    // Latihan 5
    // Daftar Flight View Id
    @RequestMapping(value = "/flight/view/{flightNumber}", method = RequestMethod.GET)
    private String viewFlight(@PathVariable(value = "flightNumber") String flightNumber, Model model) {
        FlightModel flightModel = flightService.getFlightDetailByFlightNumber(flightNumber);
        model.addAttribute("flightNumber", flightModel.getFlightNumber());
        model.addAttribute("pilot", flightModel.getPilot());
        model.addAttribute("title", "View Flight");
        return "view-flight";
    }

    // Daftar Semua Flight
    @RequestMapping(value = "/flight/viewall", method = RequestMethod.GET)
    private String viewFlights(Model model) {
        List<FlightModel> temp = flightService.getAllFlight();
        model.addAttribute("flight", temp);
        model.addAttribute("title", "View All Flight");
        return "viewall-flight";
    }
}