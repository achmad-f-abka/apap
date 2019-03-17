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
	
	@RequestMapping("/hello2, /hello2/{name}")
	public String helloPath(@PathVariable Optional <String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
//LATIHAN CALCULATOR
	@RequestMapping("/calculator/{angka1}/{angka2}")
	//method merequest parameter angka1 dan angka2 dan mengubahnya ke bentuk integer
	public String variabel(@PathVariable int angka1, @PathVariable int angka2, Model model) {
		
		//perhitungan
		int hasil = angka1+angka2;
		
		//deklarasi array untuk mengubah bilangan menjadi kata
		String[] kata = {"Nol", "Satu", "Dua", "Tiga", "Empat", "Lima", 
				"Enam", "Tujuh", "Delapan", "Sembilan", "Sepuluh", 
				"Sebelas", "Dua belas", "Tiga belas", "Empat belas", "Lima belas",
				"Enam belas", "Tujuh belas", "Delapan belas", "Sembilan belas", "Dua puluh"};
		
		//bentuk untuk ditampilkan ke view
		String angka = angka1 + "+" + angka2 + "=" + hasil + " (" + kata[hasil] +")";
		
		model.addAttribute("angka",angka);
		return "calculator";
	}
	
}

