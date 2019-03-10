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
	public String hello2(@RequestParam(value="name", required=false) String name, Model model){
		model.addAttribute("name", name);
		return "hello2";
	}
	
	@RequestMapping(value= {"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name","Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping("/calcu")
	public String calc(@RequestParam(value="angka") String angka , Model model) {
		String [] ang = {"nol","satu","dua","tiga","empat","lima",
				"enam","tujuh","delapan","sembilan","sepuluh"};
		int angka1=Integer.parseInt(angka.substring(0,1));
		int angka2=Integer.parseInt(angka.substring(1));
		
		int hasil=angka1+angka2;
		angka=angka1 + "+" + angka2 + "=" + hasil + "(" + ang[hasil] + ")";
		model.addAttribute("angka",angka);
		return "calcu";
	}
}
