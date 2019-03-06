package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//TUTORIAL 02
@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value="name") String name, Model model) {
		model.addAttribute("name",name);
		return "hello2";
	}
	@RequestMapping(value= {"/hello2/","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}else {
			model.addAttribute("name","Phoenix");
		}
		
			return "hello2";
		}
	
	//LATIHAN CALCU-CONVERT
	
	//Akses http://localhost:8080/hitung?num=11
	
	@RequestMapping("/hitung")
	public String hitung(@RequestParam(value="num") String num, Model model) {
		
		String [] angka = {"nol","satu","dua","tiga","empat","lima",
				"enam","tujuh","delapan","sembilan","sepuluh"};
		
		int num1=Integer.parseInt(num.substring(0,1));
		int num2=Integer.parseInt(num.substring(1));
		
		int hasil = num1+num2;
		
		num= num1 + "+" + num2 + "=" + hasil + "(" + angka[hasil] + ")";
		
		model.addAttribute("num",num);
		return "calcuconvert";
		
	}
	
}