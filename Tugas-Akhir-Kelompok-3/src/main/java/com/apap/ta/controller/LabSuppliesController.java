package com.apap.ta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.ta.model.LabSuppliesModel;
import com.apap.ta.service.KebutuhanReagenService;
import com.apap.ta.service.LabSuppliesService;

@Controller
public class LabSuppliesController {
	
	@Autowired
	LabSuppliesService suppliesService;
	
	@Autowired
	KebutuhanReagenService reagenService;

	@RequestMapping(value="/lab/stok/ubah", method = RequestMethod.POST)
	private String update(@ModelAttribute LabSuppliesModel labSupplies, Model model) {
		suppliesService.addSupplies(labSupplies);
		List<LabSuppliesModel> listSupplies = suppliesService.getAllSuppliesList();
		model.addAttribute("listSupplies", listSupplies);
		return "stokSupplies.html";
	}
	
	@RequestMapping(value="/lab/supplies", method = RequestMethod.GET)
	private String viewSupplies(Model model) {
		String jenis = "reagen";
		List<LabSuppliesModel> listReagen = suppliesService.getLabSuppliesByJenis(jenis);
		for (LabSuppliesModel reagen : listReagen) {
			if (reagen.getJumlah()==0){
				model.addAttribute("message", "Stok kebutuhan reagen kosong/habis! Silahkan ajukan rencana kebutuhan reagen");
				break;
			}
			else {
				model.addAttribute("message", "");
			}
		}
		List<LabSuppliesModel> listSupplies = suppliesService.getAllSuppliesList();
		model.addAttribute("listSupplies", listSupplies);
		return "stokSupplies.html";
	}
	
	@RequestMapping(value="/lab/stok/ubah/{id}", method = RequestMethod.GET)
	private String updateSupplies(@PathVariable(value="id") int id, Model model) {
		LabSuppliesModel labSupplies = suppliesService.getLabSuppliesById(id).get();
		model.addAttribute("labSupplies", labSupplies);
		return "updateSupplies.html";
	}
	@RequestMapping(value="/lab/stok/tambah", method = RequestMethod.GET)
	private String tambahSupplies (Model model) {
		LabSuppliesModel labSupplies = new LabSuppliesModel();
		model.addAttribute("labSupplies", labSupplies);
		return "tambahSupplies.html";
	}
	
	@RequestMapping(value="/lab/stok/tambah", method = RequestMethod.POST)
	private String tambah(@ModelAttribute LabSuppliesModel labSupplies, Model model) {
		suppliesService.addSupplies(labSupplies);
		model.addAttribute("message", "Data Lab Supplies Berhasil Ditambahkan!");
		String jenis = "Reagen";
		List<LabSuppliesModel> listReagen = suppliesService.getLabSuppliesByJenis(jenis);
		for (LabSuppliesModel reagen : listReagen) {
			if (reagen.getJumlah()==0){
				model.addAttribute("message", "Stok kebutuhan reagen kosong/habis! Silahkan ajukan rencana kebutuhan reagen");
				break;
			}
			else {
				model.addAttribute("message", "");
			}
		}
		List<LabSuppliesModel> listSupplies = suppliesService.getAllSuppliesList();
		model.addAttribute("listSupplies", listSupplies);
		return "stokSupplies.html";
	}
	
}
