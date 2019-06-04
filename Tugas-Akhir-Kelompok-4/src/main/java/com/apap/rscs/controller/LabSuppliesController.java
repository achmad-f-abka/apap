package com.apap.rscs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.apap.rscs.model.LabSuppliesModel;
import com.apap.rscs.service.LabSuppliesService;

@Controller
public class LabSuppliesController {
    @Autowired
    private LabSuppliesService labSuppliesService;

    // Fitur 13
    @RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("labSupplies", new LabSuppliesModel());
        return "add-lab-supplies";
    }

    @RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.POST)
    private RedirectView addLabSuppliesSubmit(@ModelAttribute LabSuppliesModel labSupplies) {
        labSuppliesService.addLabSupplies(labSupplies);
        return new RedirectView("/lab/stok");
    }

    // Fitur 14
    @RequestMapping(value = "/lab/stok", method = RequestMethod.GET)
    private String viewLabSupplies(Model model) {
        List<LabSuppliesModel> temp = labSuppliesService.getAllSupplies();
        model.addAttribute("labs", temp);
        return "view-lab-supplies";
    }

    // Fitur 15
    @RequestMapping(value = "/lab/stok/ubah/{id}", method = RequestMethod.GET)
    private String update(@PathVariable(value = "id") Long id, Model model) {
        LabSuppliesModel labSupplies = labSuppliesService.getById(id);
        model.addAttribute("labSupplies", labSupplies);
        return "edit-lab-supplies";
    }

    @RequestMapping(value = "lab/stok/ubah", method = RequestMethod.POST)
    private RedirectView updatedLabSuppliesSubmit(Model model, @ModelAttribute LabSuppliesModel labSupplies) {
        LabSuppliesModel updateLabSupplies= labSuppliesService.getById(labSupplies.getId());
        updateLabSupplies.setId(labSupplies.getId());
		updateLabSupplies.setKindOf(labSupplies.getKindOf());
		updateLabSupplies.setTotal(labSupplies.getTotal());
		updateLabSupplies.setDescription(labSupplies.getDescription());
        labSuppliesService.update(labSupplies);
        return new RedirectView("/lab/stok");
    }

}