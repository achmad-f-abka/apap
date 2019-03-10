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
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "Phoenix");
		}
		
		return "hello2";
	}
	 @RequestMapping("/calc")
	 public String calc(@RequestParam(value="ang") String ang, Model model) {
		 String [] angka = {"nol", "satu", "dua", "tiga", "empat", "lima", 
				 "enam", "tujuh", "delapan", "sembilan", "sepuluh"};
		 
		 int ang1=Integer.parseInt(ang.substring(0,1));
		 int ang2=Integer.parseInt(ang.substring(1));
		 
		 int res = ang1+ang2;
		 
		 ang = ang1 + "+" + ang2 + "=" + res + "(" + angka[res] + ")";
		 
		 model.addAttribute("ang",ang);
		 return "calcu";
	 }
	
}
