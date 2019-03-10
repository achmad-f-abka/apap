package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	@RequestMapping("/calcuconvert")
	public String hitung(@RequestParam(value="num") String num, Model model) {
		
		String [] angka = {"nol","satu","dua","tiga","empat","lima",
				"enam","tujuh","delapan","sembilan","sepuluh", "sebelas", "duabelas",
				"tigabelas", "empatbelas", "limabelas", "enambelas", "tujuhbelas", 
				"delapanbelas", "sembilanbelas", "duapuluh"};
		
		int num1=Integer.parseInt(num.substring(0,1));
		int num2=Integer.parseInt(num.substring(1));
		
		int hasil = num1+num2;
		
		num= num1 + "+" + num2 + "=" + hasil + "(" + angka[hasil] + ")";
		
		model.addAttribute("num",num);
		return "calcuconvert";
		
	}
}