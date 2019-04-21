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
	  public String hello2(@RequestParam(value = "name", required = false, defaultValue = "Thanos") String name, Model model) {
	  model.addAttribute("name", name); 
	  return "hello2"; 
	  }
	 
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping("/CalculatorConvert")
	public String calcuConvert(@RequestParam(value = "number") String number, Model model) {
		int firstNumber = Integer.parseInt(number.substring(0,1));
		int secondNumber = Integer.parseInt(number.substring(1));
		String[] numberWords = {"Nol","Satu","Dua","Tiga","Empat","Lima","Enam","Tujuh","Delapan","Sembilan","Sepuluh", 
								"Sebelas","Dua Belas","Tiga Belas","Empat Belas","Lima Belas","Enam Belas","Tujuh Belas","Delapan Belas"};
		int resultCalcu = firstNumber + secondNumber;
		number = firstNumber + "+" + secondNumber + "=" + resultCalcu + " (" + numberWords[resultCalcu] +")";
		model.addAttribute("number", number);
		return "CalculatorConvert";
	}
}