package com.apap.tu05.tutorial05.controller;

import com.apap.tu05.tutorial05.model.FlightModel;
import com.apap.tu05.tutorial05.model.PilotModel;
import com.apap.tu05.tutorial05.service.FlightService;
import com.apap.tu05.tutorial05.service.PilotService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @Autowired
    private FlightService flightService;

    @RequestMapping("/")
    private String home() {
        return "home";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pilot", new PilotModel());
        model.addAttribute("title", "Add Pilot");
        return "addPilot";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "add";
    }

    @RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
    private String viewPilot(Model model, @RequestParam(value = "licenseNumber") String licenseNumber) {
        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
//        List<FlightModel> listFlight = flightService.getFlightListByPilot(pilot);
        model.addAttribute("pilot", pilot);
//        model.addAttribute("flightlist", listFlight);
        model.addAttribute("title", "View Pilot");
        return "view-pilot";

    }

    @RequestMapping(value = "/pilot/delete/{id}", method = RequestMethod.POST)
    private String deletePilot(@PathVariable(value = "id") Long pilotid, Model model) {
        pilotService.deletePilot(pilotid);
        model.addAttribute("title", "Delete Pilot");
        return "delete";
    }

    @RequestMapping(value = "/pilot/update/{id}", method = RequestMethod.POST)
    private String updatePilot(@PathVariable(value = "id") Long pilotid, Model model) {
        PilotModel pilot = pilotService.getPilotById(pilotid).get();
        model.addAttribute("pilot", pilot);
        model.addAttribute("title", "Update Pilot");
        return "updatePilot";
    }

    @RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
    private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "update";
    }


}
