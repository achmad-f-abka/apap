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
	
	
	private long time = System.currentTimeMillis();
	
	@Autowired
	KebutuhanReagenService reagenService;
	
	@Autowired
	LabSuppliesService suppliesService;
	
	@RequestMapping(value = "/kebutuhan/tambah", method = RequestMethod.GET)
	private String tambahKebutuhan (Model model) {
		
		String jenis = "Reagen";
		List<LabSuppliesModel> listReagen = suppliesService.getLabSuppliesByJenis(jenis);
		KebutuhanReagenModel kebReagen = new KebutuhanReagenModel();
		model.addAttribute("listReagen", listReagen);
		model.addAttribute("kebReagen", kebReagen);
		
		return "tambah-reagen";
		
	}
	
	@RequestMapping(value = "/kebutuhan/tambah", method = RequestMethod.POST)
	private String tambahKebutuhanSubmit ( @ModelAttribute KebutuhanReagenModel  kebReagen, int reagen, Model model) {
		Date tanggal = new java.sql.Date(time);
		LabSuppliesModel supReagen = suppliesService.getLabSuppliesById(reagen).get();
		kebReagen.setReagen(supReagen);
		kebReagen.setTanggalUpdate(tanggal);
		kebReagen.setStatus(1);
		reagenService.addKebutuhanReagen(kebReagen);
		model.addAttribute("notif", "Data Berhasil Disimpan");
		return "lab-supplies";
	}
	
	@RequestMapping(value = "/kebutuhan", method = RequestMethod.GET)
	private String viewKebutuhan(Model model) {
		List<KebutuhanReagenModel> listKebutuhan = reagenService.getKebutuhanReagenList();
		
		if(listKebutuhan.isEmpty()) {
			model.addAttribute("listKebutuhan", listKebutuhan);
			model.addAttribute("pesan", "Belum ada pengajuan kebutuhan reagen");
			
		}
		else {
			model.addAttribute("listKebutuhan", listKebutuhan);
			model.addAttribute("pesan", "List Kebutuhan Reagen");
			
		}
		return "kebutuhan";
		
	}
	
	@RequestMapping(value="/kebutuhan/ubah/{id}", method = RequestMethod.GET)
		private String update(@PathVariable(value="id") int id, Model model) {
		KebutuhanReagenModel kebutuhan = reagenService.getKebutuhanReagenById(id).get();
		model.addAttribute("kebutuhan", kebutuhan);
		return "update-reagen";
	}
	
	@RequestMapping(value="/kebutuhan/ubah", method = RequestMethod.POST)
		private  String updateSubmit(@ModelAttribute KebutuhanReagenModel kebutuhan, int status, Model model) {
		Date tanggal = new java.sql.Date(time);
		kebutuhan.setStatus(status);
		kebutuhan.setTanggalUpdate(tanggal);
		if (kebutuhan.getStatus()==0) {
			LabSuppliesModel supplies = kebutuhan.getReagen();
			int stok = supplies.getJumlah();
			supplies.setJumlah(kebutuhan.getJumlah()+stok);
		}
		reagenService.addKebutuhanReagen(kebutuhan);
		List<KebutuhanReagenModel> listKebutuhan = reagenService.getKebutuhanReagenList();
		model.addAttribute("listKebutuhan", listKebutuhan);
		model.addAttribute("pesan", "List Kebutuhan Reagen");
		return "kebutuhan";
	}

}
