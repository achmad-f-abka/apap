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
	@RequestMapping("/calculator")
	public String coba(@RequestParam(value= "angka") String angka, Model model) {
		//men-convert dan memecah
		int a = Integer.parseInt(angka.substring(0,1));
		int b = Integer.parseInt(angka.substring(1));
		//hitung
		int hasil = a + b;
		
		String[] kata = {"Nol","Satu","Dua","Tiga","Empat","Lima",
				"Enam","Tujuh","Delapan","Sembilan","Sepuluh", 
				"Sebelas","Dua Belas","Tiga Belas","Empat Belas","Lima Belas",
				"Enam Belas","Tujuh Belas","Delapan Belas", "Sembilan Belas", "Dua puluh"};
		
		angka = a + "+" + b + "=" + hasil + " (" + kata[hasil] +")";
		model.addAttribute("angka", angka);
		return "calculator";
	}
	
	
	
	//Akses : http://localhost:8080/calculator?num=23
	
}

