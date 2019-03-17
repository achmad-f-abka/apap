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
	public String hello2(@RequestParam(value = "name", required=false, defaultValue="Thanos") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	
	@RequestMapping("/calculator")
	public String calculatorType1(@RequestParam(value="bil1") int bil1,
								  @RequestParam(value="bil2") int bil2,
								  Model model) {
		model.addAttribute("bil1", bil1);
		model.addAttribute("bil2", bil2);
		model.addAttribute("hasil", bil1+bil2);
		model.addAttribute("bilangan", Helper.eja(bil1+bil2));
		
		return "calculator";
	}
}
