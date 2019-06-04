package com.apap.rscs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.apap.rscs.model.KebutuhanReagenModel;
import com.apap.rscs.service.KebutuhanReagenService;
import com.apap.rscs.service.LabSuppliesService;


@Controller
public class KebutuhanReagenController {
	@Autowired
	private KebutuhanReagenService kebutuhanReagenService;

	@Autowired
	private LabSuppliesService labSuppliesService;
	

	@RequestMapping(value = "/lab/kebutuhan", method = RequestMethod.GET)
	public String viewReagen(Model model) {
		
        model.addAttribute("listKebutuhanReagen", kebutuhanReagenService.getAll());
		
		return "view-reagen";
	}

	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("kebutuhanReagen", new KebutuhanReagenModel());
		model.addAttribute("labSupplies", labSuppliesService.getAllSupplies());
		return "_addkebutuhanReagen";
	}

	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.POST)
	private RedirectView addKebutuhanReagenSubmit(@ModelAttribute KebutuhanReagenModel kebutuhanReagen) {
		kebutuhanReagenService.add(kebutuhanReagen);
		return new RedirectView("/lab/kebutuhan");
	}

	@RequestMapping(value = "/lab/kebutuhan/ubah/{id}", method = RequestMethod.GET)
	private String update(@PathVariable(value = "id") Long id, Model model) {
		KebutuhanReagenModel kebutuhanReagen = kebutuhanReagenService.getById(id);
		model.addAttribute("kebutuhanReagen", kebutuhanReagen);
		return "update-KebutuhanReagen";
	}

	@RequestMapping(value = "/lab/kebutuhan/ubah", method = RequestMethod.POST)
	private RedirectView updateKebutuhanReagenSubmit(@ModelAttribute KebutuhanReagenModel kebutuhanReagen) {
		KebutuhanReagenModel updatedKebReagen = kebutuhanReagenService.getById(kebutuhanReagen.getId());
		updatedKebReagen.setStatus(kebutuhanReagen.getStatus());
		updatedKebReagen.setUpdatedTime(kebutuhanReagen.getUpdatedTime());
		kebutuhanReagenService.update(kebutuhanReagen);
		return new RedirectView("/lab/kebutuhan");
	}

}
