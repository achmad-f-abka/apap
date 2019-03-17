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
	public String hello() {
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
		}
		else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping(value= {"/calculator/first/{firstNumber}/second/{secondNumber}/arith/{arith}"})
	 public String calc(@PathVariable int firstNumber, @PathVariable int secondNumber, @PathVariable String arith, Model model) {
	  model.addAttribute("firstNumber", firstNumber);
	  model.addAttribute("secondNumber", secondNumber);
	  model.addAttribute("arith", arith);
	  return "calculator";
	 }
	
}
