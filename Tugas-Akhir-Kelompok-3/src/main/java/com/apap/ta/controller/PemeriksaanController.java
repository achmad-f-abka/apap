package com.apap.ta.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.ta.model.PemeriksaanModel;
import com.apap.ta.service.PemeriksaanService;

@Controller
@RequestMapping("/lab/pemeriksaanLab")
public class PemeriksaanController {
	
	private long time = System.currentTimeMillis();

	@Autowired
	PemeriksaanService pemeriksaanService;
	
	@RequestMapping(value="/ubah", method=RequestMethod.POST)
	private String update(@ModelAttribute PemeriksaanModel pemeriksaanLab,int status, Model model) {
		Date tanggal = new java.sql.Date(time);
		pemeriksaanLab.setStatus(status);
		int stokLab = pemeriksaanLab.getJenis().getSupplies().getJumlah();
		if(pemeriksaanLab.getStatus()==2) {
			if (stokLab > 0) { 
				pemeriksaanLab.setTanggalPemeriksaan(tanggal);
				pemeriksaanLab.getJenis().getSupplies().setJumlah(stokLab-1);
				pemeriksaanService.addPemeriksaan(pemeriksaanLab);
			}
			else {
				model.addAttribute("labSupplies", "Supplies kosong !");
			}
		}
		else if(pemeriksaanLab.getStatus()==3) {
			pemeriksaanService.addPemeriksaan(pemeriksaanLab);
		}
		List<PemeriksaanModel> listPemeriksaan = pemeriksaanService.getPemeriksaanList();
		model.addAttribute("listPemeriksaan", listPemeriksaan);
		
		return "viewPemeriksaan.html";
		
	}
	
	@RequestMapping(value="/permintaan", method=RequestMethod.GET)
	private String viewPemeriksaanLab(Model model) {
		List<PemeriksaanModel> list = pemeriksaanService.getPemeriksaanList();
		model.addAttribute("listPemeriksaan", list);
		return "viewPemeriksaan.html";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	private String updatePemeriksaan(@PathVariable(value="id") int id, Model model) {
		PemeriksaanModel pemeriksaanLab = pemeriksaanService.getPemeriksaanById(id).get();
		int currentStatus = pemeriksaanLab.getStatus();
		int futureStatus =  currentStatus +1;
		List<Integer> listStatus = new ArrayList<Integer>();
		if (currentStatus == 3) {
			listStatus.add(currentStatus);
		}
		else {
			listStatus.add(currentStatus);
			listStatus.add(futureStatus);
		}
		model.addAttribute("pemeriksaanLab", pemeriksaanLab);
		model.addAttribute("listStatus", listStatus);
		return "updatePemeriksaan.html";
	}
	


}
