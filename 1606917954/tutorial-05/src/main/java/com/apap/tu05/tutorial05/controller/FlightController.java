package com.apap.tu05.tutorial05.controller;

import com.apap.tu05.tutorial05.model.FlightModel;
import com.apap.tu05.tutorial05.model.PilotModel;
import com.apap.tu05.tutorial05.service.FlightService;
import com.apap.tu05.tutorial05.service.PilotService;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;
import java.util.List;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private PilotService pilotService;

    @RequestMapping(value="/flight/add/{licenseNumber}", method = RequestMethod.GET)
    private String add (@PathVariable(value = "licenseNumber") String licenseNumber,Model model) {
        FlightModel flight = new FlightModel();
        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        ArrayList<FlightModel> pilotFlight = new ArrayList<>();
        pilotFlight.add(flight);
        pilot.setPilotFlight(pilotFlight);

        flight.setPilot(pilot);
        model.addAttribute("pilot", pilot);
        model.addAttribute("flight", flight);
        model.addAttribute("title", "Add Flight");
        return "addFlight";
    }

    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.POST, params= {"submit"})
    private String addFlightSubmit(@ModelAttribute PilotModel pilot) {
        PilotModel pilotnya = pilotService.getPilotDetailByLicenseNumber(pilot.getLicenseNumber());
        for (FlightModel flight : pilot.getPilotFlight()) {
            flight.setPilot(pilotnya);
            flightService.addFlight(flight);
        }

        return "add";
    }

    @RequestMapping(value="/flight/add/{licenseNumber}", method = RequestMethod.POST, params={"addRow"})
    public String addRow(@ModelAttribute PilotModel pilot, BindingResult bindingResult, Model model) {
        if(pilot.getPilotFlight() == null) {
            pilot.setPilotFlight(new ArrayList<FlightModel>());
        }

        pilot.getPilotFlight().add(new FlightModel());
        model.addAttribute("pilot", pilot);
        model.addAttribute("title", "Add Flight");
        return "addFlight";
    }


//    @RequestMapping(value = "/flight/delete/{id}", method = RequestMethod.POST)
//    private String deleteFlight(@PathVariable(value = "id") Long flightid, Model model) {
//        flightService.deleteFlight(flightid);
//        model.addAttribute("title", "Delete Flight");
//        return "delete";
//    }

    @RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
    private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
        for(FlightModel flight : pilot.getPilotFlight()){
            flightService.deleteFlight(flight.getId());
        }
        model.addAttribute("title", "Delete Flight");
        return "delete";
    }

    @RequestMapping(value = "/flight/all", method = RequestMethod.GET)
    private String allFlight(Model model) {
        List<FlightModel> list = flightService.getAllFlightList();
        model.addAttribute("all", list);
        model.addAttribute("title", "All Flight");
        return "allFlight";
    }

}
