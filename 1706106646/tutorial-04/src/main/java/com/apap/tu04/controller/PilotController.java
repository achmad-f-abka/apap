package com.apap.tu04.controller;

import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PilotController
 */
@Controller
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @RequestMapping("/")
    private String home() {
        return "home";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pilot", new PilotModel());
        return "addPilot";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "add";
    }

    // Latihan 1
    // Method view with PathVariable
    // Example : localhost:8080/pilot/view?licenseNumber=1
    // --------------------------------------------
    @RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
    public String viewPilot(Model model, @RequestParam(value = "licenseNumber") String licenseNumber) {
        PilotModel pilot = pilotService.getPilotDetailBylicenseNumber(licenseNumber);
        model.addAttribute("pilot", pilot);
        model.addAttribute("flights", pilot.getPilotFlight());
        return "view-pilot";
    }

    // Latihan 3
    // Membuat Fitur Delete Pilot
    @RequestMapping(value = "/pilot/delete/{id}", method = RequestMethod.GET)
    private String delPilot(@PathVariable(value = "id") Long id) {
        pilotService.deletePilot(id);
        return "delete-pilot";
    }

    // Latihan 4
    // Membuat Fitur Update Pilot
    // Method Get Update
    @RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
    private String updatingPilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
        PilotModel pilot = pilotService.getPilotDetailBylicenseNumber(licenseNumber);
        model.addAttribute("update", pilot);
        return "update-pilot";
    }

    // Method POST Update
    @RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
    private String pilotUpdated(@ModelAttribute PilotModel pilot) {
        pilotService.updatePilot(pilot, pilot.getLicenseNumber());
        return "updated-pilot";
    }

}