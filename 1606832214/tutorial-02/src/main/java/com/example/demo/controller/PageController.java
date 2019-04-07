package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
//	@RequestMapping("/hello2")
//	public String hello2(@RequestParam(value = "name") String name, Model model) {
//		model.addAttribute("name", name);
//		return "hello2";
//	}
	@RequestMapping(value={"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	@RequestMapping(value= {"/calcu", "/calcu/{number}"})
	public String calcuConvert(@PathVariable Optional<String> number, Model model) {
		String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
				"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen"};
		if (number.isPresent() && (number.get()).length() == 2) {
			int num1 = Integer.parseInt((number.get()).substring(0,1)); //string to int
			int num2 = Integer.parseInt((number.get()).substring(1));
			int total = num1 + num2;
			String output = num1 + " + " + num2 + " = " + total + " (" + words[total] +")";
			model.addAttribute("number", output);
		} else {
			String output = "0 + 0 = 0 " + "(" + words[0] +")";
			model.addAttribute("number", output);
		}
		return "calcu";
	}
}
