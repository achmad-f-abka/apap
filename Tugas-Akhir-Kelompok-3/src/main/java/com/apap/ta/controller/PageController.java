package com.apap.ta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/kebutuhan", method=RequestMethod.GET)
	private String kebutuhan() {
		return "kebutuhanReagen.html";
	}
	
	@RequestMapping(value="/pemeriksaanLab/permintaan", method=RequestMethod.GET)
	private String pemeriksaaan() {
		return "viewPemeriksaan.html";
	}
	
	@RequestMapping(value="/supplies", method=RequestMethod.GET)
	private String suppllies() {
		return "stokSupplies.html";
	}
	
	@RequestMapping(value="/lab/jadwal", method=RequestMethod.GET)
	private String jadwal() {
		return "kelolaJadwal.html";
	}
	
	@RequestMapping(value="/pasien")
	public String daftarPasien() {
		return "home.html";
	}
	
	@RequestMapping(value="/staf")
	public String daftarStaf() {
		return "home.html";
	}

	@RequestMapping(value="/akun", method=RequestMethod.GET)
	private String update() {
		return "kelolaUser.html";
	}
	
	
	
	
	
	
	

}
