package com.apap.ta.controller;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.apap.ta.model.KebutuhanReagenModel;
import com.apap.ta.model.LabSuppliesModel;
import com.apap.ta.service.KebutuhanReagenService;
import com.apap.ta.service.LabSuppliesService;

@Controller
@RequestMapping("/lab/")
public class KebutuhanReagenController {

	@Autowired
	KebutuhanReagenService reagenService;
	
	@Autowired
	LabSuppliesService suppliesService;
	
	private long time = System.currentTimeMillis();
	
	
	@RequestMapping(value = "/kebutuhan", method = RequestMethod.GET)
	private String viewKebutuhan(Model model) {
		List<KebutuhanReagenModel> listKebutuhan = reagenService.getKebutuhanReagenList();
		
		if(listKebutuhan.isEmpty()) {
			model.addAttribute("listKebutuhan", listKebutuhan);
			model.addAttribute("message", "Perencanaan Kebutuhan Reagen Belum Diajukan!");
			
		}
		else {
			model.addAttribute("listKebutuhan", listKebutuhan);	
		}
		return "kebutuhanReagen.html";
	}
	
	@RequestMapping(value="/kebutuhan/ubah/{id}", method = RequestMethod.GET)
		private String updateReagen(@PathVariable(value="id") int id, Model model) {
		KebutuhanReagenModel persediaan = reagenService.getKebutuhanReagenById(id).get();
		model.addAttribute("persediaan", persediaan);
		return "updateReagen.html";
	}
	
	@RequestMapping(value="/kebutuhan/ubah", method = RequestMethod.POST)
		private  String update(@ModelAttribute KebutuhanReagenModel persediaan, int status, Model model) {
		Date tanggal = new java.sql.Date(time);
		persediaan.setStatus(status);
		persediaan.setTanggalUpdate(tanggal);
		if (persediaan.getStatus()==0) {
			LabSuppliesModel supplies = persediaan.getReagen();
			int stokSupplies = supplies.getJumlah();
			supplies.setJumlah(persediaan.getJumlah()+stokSupplies);
		}
		reagenService.addKebutuhanReagen(persediaan);
		List<KebutuhanReagenModel> listKebutuhan = reagenService.getKebutuhanReagenList();
		model.addAttribute("listKebutuhan", listKebutuhan);
		model.addAttribute("message", "Data Kebutuhan Reagen Berhasil Diubah!");
		return "kebutuhanReagen.html";
	}
	
	
	@RequestMapping(value = "/kebutuhan/tambah", method = RequestMethod.POST)
	private String tambahKebutuhan( @ModelAttribute KebutuhanReagenModel  perReagen, int reagen, Model model) {
		Date tanggal = new java.sql.Date(time);
		LabSuppliesModel suppliesReagen = suppliesService.getLabSuppliesById(reagen).get();
		perReagen.setReagen(suppliesReagen);
		perReagen.setTanggalUpdate(tanggal);
		perReagen.setStatus(1);
		reagenService.addKebutuhanReagen(perReagen);
		model.addAttribute("message", "Data Kebutuhan Reagen Berhasil Ditambahkan!");
		List<KebutuhanReagenModel> listKebutuhan = reagenService.getKebutuhanReagenList();
		
		if(listKebutuhan.isEmpty()) {
			model.addAttribute("listKebutuhan", listKebutuhan);
			model.addAttribute("message", "Perencanaan Kebutuhan Reagen Belum Diajukan!");
			
		}
		else {
			model.addAttribute("listKebutuhan", listKebutuhan);	
		}
		return "kebutuhanReagen.html";
	}
	
	@RequestMapping(value = "/kebutuhan/tambah", method = RequestMethod.GET)
	private String tambahReagen (Model model) {
		
		String jenis = "reagen";
		List<LabSuppliesModel> listReagen = suppliesService.getLabSuppliesByJenis(jenis);
		KebutuhanReagenModel perReagen = new KebutuhanReagenModel();
		model.addAttribute("listReagen", listReagen);
		model.addAttribute("perReagen", perReagen);
		
		return "tambahReagen.html";
		
	}

}
