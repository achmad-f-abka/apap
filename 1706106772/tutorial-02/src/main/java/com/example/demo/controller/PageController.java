package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.ModelCalculator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

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
	@RequestMapping(value={"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name","Phoenix");
		}
		return "hello2";
	}
	
	    @RequestMapping(value="/calculator", method = RequestMethod.GET)
	    public String getCalculatorPage(){
	        return "calculator";
	    }
	    
	    @RequestMapping(value="/calculator", method = RequestMethod.POST)
	    public String ProcessCalculation(@RequestParam("num1")int num1, @RequestParam("num2")int num2, @ModelAttribute (name = "calculation")ModelCalculator calculation, ModelMap model){
	    	calculation.setBilanganSatu(num1);
	    	calculation.setBilanganDua(num2);
	    	
	    	model.addAttribute("satu", calculation.getBilanganSatu());
	    	model.addAttribute("dua", calculation.getBilanganSatu());
	    	
	    	int result = calculation.proses(num1, num2);
	    	model.addAttribute("result", result);
	    	
	    	String terbilang = calculation.terbilang(result);
	    	model.addAttribute("terbilang", terbilang);
	        return "calculator";        
	    }	
}