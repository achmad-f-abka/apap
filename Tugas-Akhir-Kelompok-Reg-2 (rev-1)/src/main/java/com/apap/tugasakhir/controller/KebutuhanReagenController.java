package com.apap.tugasakhir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.apap.tugasakhir.model.KebutuhanReagenModel;
import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.service.KebutuhanReagenService;
import com.apap.tugasakhir.service.LabSuppliesService;

@Controller
public class KebutuhanReagenController {
	@Autowired
	private KebutuhanReagenService kebutuhanReagenService;
	
	@Autowired
	private LabSuppliesService labSuppliesService;
	
	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.GET)
	private String addKebutuhanReagen(Model model) {
		List<LabSuppliesModel> listReagen = labSuppliesService.getListLabSupplies();
		model.addAttribute("kebutuhanReagen", new KebutuhanReagenModel());
		model.addAttribute("listReagen", listReagen);
		return "addKebutuhanReagen";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.POST)
	private String addKebutuhanReagenSubmit(@ModelAttribute KebutuhanReagenModel kebutuhanReagen, Model model) {
		kebutuhanReagenService.addKebutuhanReagen(kebutuhanReagen);
		model.addAttribute("success", "true");
		return "addKebutuhanReagen";
	}
	
	@RequestMapping(value = "/lab/kebutuhan")
	private String viewAllKebutuhanReagen(Model model) {
		List<KebutuhanReagenModel> listKebutuhanReagen = kebutuhanReagenService.getListKebutuhanReagen();
		model.addAttribute("listKebutuhanReagen", listKebutuhanReagen);
		return "viewKebutuhanReagen";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/ubah/{id}", method = RequestMethod.GET)
	private String updateKebutuhanReagen(@PathVariable(value="id") int id, Model model) {
		KebutuhanReagenModel kebutuhanReagen = kebutuhanReagenService.getKebutuhanReagenById(id).get();
		model.addAttribute("kebutuhanReagen", kebutuhanReagen);
		return "updateKebutuhanReagen";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/ubah", method = RequestMethod.POST)
	private String updateKebutuhanReagenSubmit(@ModelAttribute KebutuhanReagenModel kebutuhanReagen, Model model) {
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		kebutuhanReagen.setTanggalUpdate(sqlDate);
		kebutuhanReagenService.addKebutuhanReagen(kebutuhanReagen);
		List<KebutuhanReagenModel> listKebutuhanReagen = kebutuhanReagenService.getListKebutuhanReagen();
		model.addAttribute("listKebutuhanReagen", listKebutuhanReagen);
		model.addAttribute("kebutuhanReagen", kebutuhanReagen);
		model.addAttribute("success", "true");
		return "viewKebutuhanReagen";
	}
}
