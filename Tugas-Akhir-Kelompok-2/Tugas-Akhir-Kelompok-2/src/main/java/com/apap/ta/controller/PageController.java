package com.apap.ta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/manajemen-akun", method=RequestMethod.GET)
	private String update() {
		return "manajemen-akun";
	}
	
	@RequestMapping(value="/lab/supplies", method=RequestMethod.GET)
	private String labSupplies() {
		return "lab-supplies";
	}
	
	@RequestMapping(value="/lab/ManajemenJadwal", method=RequestMethod.GET)
	private String penjadwalan() {
		return "manajemen-jadwal";
	}
	

}
