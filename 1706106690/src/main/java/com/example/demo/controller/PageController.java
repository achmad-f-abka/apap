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
	
	@RequestMapping(value="/calcuConvert")
		public String count(@RequestParam(value = "num1", required = false, defaultValue = "0") int num1, 
							@RequestParam(value = "num2", required = false, defaultValue = "0") int num2, Model model) {
			
					
			String [] mentionNum = {"Nol","Satu","Dua","Tiga","Empat","Lima",
					"Enam","Tujuh","Delapan","Sembilan","Sepuluh",
					"Sebelas", "Dua belas", "Tiga belas", "Empat belas", "Lima belas",
					"Enam belas", "Tujuh belas", "Delapan belas", "Sembilan belas", "Dua puluh"}; //dan seterusnya
		
			int result = num1 + num2;
			
			String cetak = Integer.toString(num1) + "+" + Integer.toString(num2) + "=" + Integer.toString(result) + "(" + mentionNum[result] + ")";
			
			model.addAttribute("cetak", cetak);
			return "calcuConvert";
			
	}
	
	
	//diakses ke alamat http://localhost:3000/calcuConvert?num1=2&num2=3 -----> maksudnya 2 + 3
}
