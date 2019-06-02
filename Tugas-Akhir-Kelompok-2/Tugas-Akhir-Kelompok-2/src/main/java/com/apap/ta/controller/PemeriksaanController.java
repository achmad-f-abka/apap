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
@RequestMapping("/lab/pemeriksaan")
public class PemeriksaanController {
	
	private long time = System.currentTimeMillis();
	
	
	@Autowired
	PemeriksaanService pemeriksaanService;
	
	@RequestMapping(value="/permintaan", method=RequestMethod.GET)
	private String viewPemeriksaan (Model model) {
		List<PemeriksaanModel> listPemeriksaan = pemeriksaanService.getPemeriksaanList();
		model.addAttribute("listPemeriksaan", listPemeriksaan);
		return "daftar-pemeriksaan";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	private String updatePemeriksaan(@PathVariable(value="id") int id, Model model) {
		PemeriksaanModel pemeriksaan = pemeriksaanService.getPemeriksaanById(id).get();
		int currStatus = pemeriksaan.getStatus();
		int nextStatus =  currStatus +1;
		List<Integer> listStatus = new ArrayList<Integer>();
		if (currStatus == 3) {
			listStatus.add(currStatus);
		}
		else {
			listStatus.add(currStatus);
			listStatus.add(nextStatus);
		}
		model.addAttribute("pemeriksaan", pemeriksaan);
		model.addAttribute("listStatus", listStatus);
		return "update-pemeriksaan";
	}
	
	@RequestMapping(value="/ubah", method=RequestMethod.POST)
	private String updatePemeriksaanSubmit(@ModelAttribute PemeriksaanModel pemeriksaan,int status, Model model) {
		Date tanggal = new java.sql.Date(time);
		pemeriksaan.setStatus(status);
		int stok = pemeriksaan.getJenis().getSupplies().getJumlah();
		if(pemeriksaan.getStatus()==2) {
			if (stok > 0) { //cek supply tidak kosong
				pemeriksaan.setTanggalPemeriksaan(tanggal);
				pemeriksaan.getJenis().getSupplies().setJumlah(stok-1);
				pemeriksaanService.addPemeriksaan(pemeriksaan);
			}
			else {
				model.addAttribute("notif", "Supplies yang dibutuhkan kosong !");
			}
		}
		else if(pemeriksaan.getStatus()==3) {
			pemeriksaanService.addPemeriksaan(pemeriksaan);
		}
		List<PemeriksaanModel> listPemeriksaan = pemeriksaanService.getPemeriksaanList();
		model.addAttribute("listPemeriksaan", listPemeriksaan);
		
		return "daftar-pemeriksaan";
		
	}

}
