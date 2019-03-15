package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping("/Calcu")
	public String calcu(@RequestParam(value = "angka") String angka, Model model) {
		String[] kata = {"Nol", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam",
				"Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas", 
				"Dua Belas", "Tiga Belas", "Empat Belas", "Lima Belas",
				"Enam Belas", "Tujuh Belas", "Delapan Belas"};
		
		int angkaPertama = Integer.parseInt(angka.substring(0,1));
		int angkaKedua = Integer.parseInt(angka.substring(1));
		int hasil = angkaPertama + angkaKedua;
		angka = angkaPertama + "+" + angkaKedua + "=" + hasil + " (" + kata[hasil] +")";
		model.addAttribute("angka", angka);
		
		return "Calcu";
	}
	/*
	 * Penggunaan: localhost:8080/Calcu?angka=(angka pertama)(angka kedua)
	 * Contoh: localhost:8080/Calcu?angka=22
	 */
	

}
