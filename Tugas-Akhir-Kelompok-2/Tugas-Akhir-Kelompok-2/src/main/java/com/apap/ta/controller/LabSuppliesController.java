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
	
	
	@RequestMapping(value="/lab/stok/tambah", method = RequestMethod.GET)
	private String tambahSupply (Model model) {
		LabSuppliesModel labSupplies = new LabSuppliesModel();
		model.addAttribute("labSupplies", labSupplies);
		return "tambah-supply";
	}
	
	@RequestMapping(value="/lab/stok/tambah", method = RequestMethod.POST)
	private String tambahSupplySubmit (@ModelAttribute LabSuppliesModel labSupplies, Model model) {
		suppliesService.addLabSupplies(labSupplies);
		model.addAttribute("notif", "Data Berhasil Ditambahkan");
		return "lab-supplies";
	}
	
	@RequestMapping(value="/lab/stok", method = RequestMethod.GET)
	private String viewSupplies(Model model) {
		String jenis = "Reagen";
		List<LabSuppliesModel> listReagen = suppliesService.getLabSuppliesByJenis(jenis);
		for (LabSuppliesModel reagen : listReagen) {
			if (reagen.getJumlah()==0){
				String namaReagen = reagen.getNama();
				model.addAttribute("notif", "Stok reagen "+namaReagen+" kosong/habis! Silahkan ajukan rencana kebutuhan reagen");
				break;
			}
			else {
				model.addAttribute("notif", "");
			}
		}
		List<LabSuppliesModel> listSupplies = suppliesService.getAllSuppliesList();
		model.addAttribute("listSupplies", listSupplies);
		return "stok-supply";
	}
	
	@RequestMapping(value="/lab/stok/ubah/{id}", method = RequestMethod.GET)
	private String updateStok(@PathVariable(value="id") int id, Model model) {
		LabSuppliesModel supplies = suppliesService.getLabSuppliesById(id).get();
		model.addAttribute("supplies", supplies);
		return "update-stok";
	}
	
	@RequestMapping(value="/lab/stok/ubah", method = RequestMethod.POST)
	private String updateStokSubmit(@ModelAttribute LabSuppliesModel supplies, Model model) {
		suppliesService.addLabSupplies(supplies);
		List<LabSuppliesModel> listSupplies = suppliesService.getAllSuppliesList();
		model.addAttribute("listSupplies", listSupplies);
		return "stok-supply";
	}
}
