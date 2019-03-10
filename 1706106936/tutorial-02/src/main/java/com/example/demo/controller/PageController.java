package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping ("/hello")
	public String index() {
		return "hello";
	}
	
	
	
	
	
	@RequestMapping(value={"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name,  Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "phoenix");
		}
		return "hello2";
	}
	
	
	@RequestMapping(value= "/calculator/{nums}")
	public String hitung(@PathVariable String nums, Model model) {
		//Penghitungan angka
		model.addAttribute("nums", nums);
		int num1 = Integer.parseInt(Character.toString(nums.charAt(0)));
		model.addAttribute("num1", num1);
		int num2 = Integer.parseInt(Character.toString(nums.charAt(1)));
		model.addAttribute("num2", num2);
		int hasil = num1+num2;
		model.addAttribute("hasil", hasil);
		
		//Generate nama angka
		String[] hsljumlah = {
				"Nol",
				"Satu",
				"Dua",
				"Tiga",
				"Empat",
				"Lima",
				"Enam",
				"Tujuh",
				"Delapan",
				"Sembilan",
				"Sepuluh",
				"Sebelas",
				"Dua Belas",
				"Tiga Belas",
				"Empat Belas",
				"Lima Belas",
				"Enam Belas",
				"Tujuh Belas",
				"Delapan Belas",
				"Sembilan Belas",
				"Dua Puluh"	};
		
		String bilangan = hsljumlah[hasil];
		model.addAttribute("bilangan", bilangan);
		
		
		
		return "calculator";
	}
}
