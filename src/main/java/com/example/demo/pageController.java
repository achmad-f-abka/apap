package com.example.demo;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value="name", required = false, defaultValue = "") String name,Model model) {
		model.addAttribute("name",name);
		return "hello2";
	}
	@RequestMapping(value= {"/hello2/","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name",name.get());
		} else {
			model.addAttribute("name","Phoenix");
		}
		
		return "hello2";
}
	@RequestMapping("/sum/{num1}/{num2}")

	public String calcu(@PathVariable String num1, @PathVariable String num2, Model model) {
		
		
		String[] kata = {"Nol", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam",
				"Tujuh", "Delapan", "Sembilan", "Sepuluh", "Sebelas", 
				"Dua Belas", "Tiga Belas", "Empat Belas", "Lima Belas",
				"Enam Belas", "Tujuh Belas", "Delapan Belas"};
		
		int firstN = Integer.parseInt(num1);
		int secondN = Integer.parseInt(num2);
		
		int sum = firstN + secondN;
		
		String numb = firstN + " + " + secondN + " = " + sum + " (" + kata[sum] +")";
		
		model.addAttribute("numb", numb);
		
		return "calcuconvert";
	}
}

