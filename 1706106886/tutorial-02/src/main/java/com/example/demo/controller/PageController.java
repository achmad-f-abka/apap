package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/aloha")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value="name")String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
		
	}

	
	@RequestMapping(value= {"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	

	@RequestMapping("/hitung/{angka}")
	public String tambah(@PathVariable("angka") String angka, Model model) {
		String a = angka.substring(0,1);
		String b = angka.substring(1);

		String [] angkaHuruf = {"Nol","Satu","Dua","Tiga","Empat","Lima","Enam","Tujuh","Delapan","Sembilan","Sepuluh",
				"Sebelas", "Dua belas", "Tiga belas", "Empat belas", "Lima belas","Enam belas", 
				"Tujuh belas", "Delapan belas", "Sembilan belas", "Dua puluh"};
		
		int angka1 = Integer.parseInt(a);
		int angka2= Integer.parseInt(b);
		
		int hasil = angka1 + angka2;

		angka = a + "+" + b + "=" + Integer.toString(hasil) + "(" + angkaHuruf[hasil] + ")";

		model.addAttribute("angka", angka);
		
		return "tambah";
	}
	
}
	