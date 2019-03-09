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
	/*@RequestMapping("/hello2")
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
*/	
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping(value="/calcuConvert/{num}")
		public String count(@RequestParam(value = "num") String num, Model model) {
			
			String a = num.substring(0,1);
			String b = num.substring(1);
		
			int num1 = Integer.parseInt(a);
			int num2= Integer.parseInt(b);
		
			String [] mentionNum = {"Nol","Satu","Dua","Tiga","Empat","Lima",
					"Enam","Tujuh","Delapan","Sembilan","Sepuluh",
					"Sebelas", "Dua belas", "Tiga belas", "Empat belas", "Lima belas",
					"Enam belas", "Tujuh belas", "Delapan belas", "Sembilan belas", "Dua puluh"}; //dan seterusnya
		
			int result = num1 + num2;
			
			num = a + "+" + b + "=" + Integer.toString(result) + "(" + mentionNum[result] + ")";
			
			model.addAttribute("num", num);
			return "calcuConvert";
			
	}
	//diakses ke alamat http://localhost:3000/calcuConvert/12 -----> maksudnya 1 + 2
}
