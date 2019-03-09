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
//	@RequestMapping("/hello2/{name}")
//	public String helloPath(@PathVariable String name, Model model) {
//		model.addAttribute("name", name);	
//		return "hello2";
//	}
	@RequestMapping(value= {"/hello2", "hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "Phoenix");
		}
			
		return "hello2";
	}
	@RequestMapping("/calculator")
	public String calculator(@RequestParam(value = "a",required = false, defaultValue = "0") Integer a,
			@RequestParam(value = "b",required = false, defaultValue = "0") Integer b, Model model) {
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute(a+b);
		return "calculator";
	}
}
