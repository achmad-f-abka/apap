package com.apap.tugasakhir.controller;

import java.util.List;
import java.util.Optional;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.service.LabSuppliesService;

@Controller
public class LabSuppliesController {
	@Autowired
	private LabSuppliesService labSuppliesService;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	@RequestMapping(value="/lab/stok/tambah", method=RequestMethod.GET)
	private String addLabSupplies(Model model) {
		model.addAttribute("lab", new LabSuppliesModel());
		return "addLabSupplies";
	}
	
	@RequestMapping(value="/lab/stok/tambah", method=RequestMethod.POST)
	private String addLabSuppliesSubmit(@ModelAttribute LabSuppliesModel labSupplies, Model model) {
		labSuppliesService.addSupplies(labSupplies);
		model.addAttribute("id", labSupplies.getId());
		model.addAttribute("success", "true");
		return "addLabSupplies";
	}
	
	@RequestMapping(value="/lab/stok/view", method=RequestMethod.GET)
	public String viewLabSupplies(@RequestParam(value="id", required=true) int idSupplies, Model model) {
		LabSuppliesModel archieve = labSuppliesService.findLabSuppliesDetailById(idSupplies).get();
		model.addAttribute("supply", archieve);
		return "viewLabSupplies";
	}
	
	@RequestMapping(value="/lab/stok", method=RequestMethod.GET)
	public String viewAllLabSupplies(Model model) {
		List<LabSuppliesModel> suppliesList = labSuppliesService.getListLabSupplies();
		HashMap<String, Integer> numOnSupplies = labSuppliesService.getNumOnSupplies(suppliesList);
		model.addAttribute("suppliesList", suppliesList);
		model.addAttribute("numOnSupplies", numOnSupplies);
		return "viewAllLabSupplies";
	}
	
	@RequestMapping(value="/lab/stok/ubah/{id}", method=RequestMethod.GET)
	private String updateLabSupplies(@PathVariable(value="id", required=true) String id, Model model) {
		int parseId = Integer.parseInt(id);
		LabSuppliesModel labSuppliesLama = labSuppliesService.findLabSuppliesDetailById(parseId).get();
		model.addAttribute("lab", labSuppliesLama);
		return "updateLabSupplies";
	}
	
	@RequestMapping(value="/lab/stok/ubah", method=RequestMethod.POST)
	private String updateLabSuppliesSubmit(@ModelAttribute LabSuppliesModel labSupplies, Model model) {
		labSuppliesService.updateLabSupplies(labSupplies.getId(), labSupplies);
		model.addAttribute("id", labSupplies.getId());
		return "updateLabSuppliesSuccess";
	}
}
