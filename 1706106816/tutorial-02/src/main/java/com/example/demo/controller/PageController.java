package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/aloha")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/hello/hello2")
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	
	@RequestMapping(value={"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping(value={"/calculator/{angka1}/{angka2}"})
	//mmethod meminta parameter angka1 dan angka2
	//PathVariable angka1 dan angka2 diubah ke integer
	public String calculator(@PathVariable("angka1") int angka1, @PathVariable("angka2") int angka2, Model model) {
		//array huruf untuk pengubahan angka ke huruf
		String[] huruf = {"Nol", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sembilan", 
							"Sepuluh", "Sebelas", "Dua belas", "Tiga belas", "Empat belas", "Lima belas",
							"Enam belas", "Tujuh belas", "Delapan belas", "Sembilan belas", "Dua puluh"};
		//deklarasi value expression hasil dan teks pada template calculator.html
		model.addAttribute("hasil", angka1+angka2);
		model.addAttribute("teks", huruf[angka1+angka2]);
		return "calculator";
	}
}
