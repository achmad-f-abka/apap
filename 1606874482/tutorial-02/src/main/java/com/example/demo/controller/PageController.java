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
	public String index(){
		return "hello";
	}
	/*@RequestMapping("/hello2")
	public String hello2(@RequestParam(value="name") String name,Model model) {
	model.addAttribute("name", name);
	return "hello2";
	}*/
	
	@RequestMapping( value = {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	@RequestMapping("/calcu")
	public String total(@RequestParam(value="angka") String angka, Model model) {
		int angka1 = Integer.parseInt(angka.substring(0,1)); //string to int
		int angka2= Integer.parseInt(angka.substring(1));
		int sum  = angka1 + angka2;
		int pjg = angka.length(); 
		String[] hasil = {"Nol", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam",
		  				"Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas", 
						"Dua Belas", "Tiga Belas", "Empat Belas", "Lima Belas",
						"Enam Belas", "Tujuh Belas", "Delapan Belas"};
		if(pjg!=2){
			model.addAttribute("angka", "kebanyakkan harusnya 2 angka");
		}
		else {
			angka = angka.substring(0, 1)+ " + " + angka.substring(1) +" = " + sum +"(" + hasil[sum] + ")" ;
			model.addAttribute("angka", angka);
		}
		return "calcu";
	}
	 
}
