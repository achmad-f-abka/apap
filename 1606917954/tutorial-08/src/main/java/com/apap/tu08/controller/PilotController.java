package com.apap.tu08.controller;

import java.util.Optional;

import com.apap.tu08.model.UserRoleModel;
import com.apap.tu08.repository.UserRoleDb;
import com.apap.tu08.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tu08.model.PilotModel;
import com.apap.tu08.service.PilotService;

/**
 * PilotController
 */
@Controller
public class PilotController {
    private UserRoleModel userModel;
    @Autowired
    private PilotService pilotService;
    @Autowired
    private UserRoleDb userRoleDb;

//    @RequestMapping("/")
//    private String home() {
//        return "home";
//    }

    @RequestMapping(value = "/admin")
    private String admin(Model model) {
        UserRoleModel admin = userRoleDb.findByUsername(userModel.getUsername());
        model.addAttribute("admin", admin);
        return "admin";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pilot", new PilotModel());
        return "add-pilot";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "add";
    }

    @RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
    private String view(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        Optional<PilotModel> archivePilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);

        model.addAttribute("pilot", archivePilot.get());
        return "view-pilot";
    }

    @RequestMapping(value = "/pilot/delete", method = RequestMethod.GET)
    private String delete(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        pilotService.deletePilotByLicenseNumber(licenseNumber);
        return "delete";
    }

    @RequestMapping(value = "/pilot/update", method = RequestMethod.GET)
    private String update(@RequestParam(value = "licenseNumber") String licenseNumber, Model model) {
        Optional<PilotModel> archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        model.addAttribute("pilot", archive.get());
        return "update-pilot";
    }

    @RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
    private @ResponseBody PilotModel updatePilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
        pilotService.addPilot(pilot);
        return pilot;
    }
}