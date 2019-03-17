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
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	@RequestMapping(value = {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	@RequestMapping(value = {"/calcuconvert", "/calcuconvert/{num1}/{num2}"})
	public String calcuconvert(@PathVariable(value = "num1") int num1, @PathVariable(value = "num2") int num2, Model model) {
		int tambah = num1+num2;
		String[] num = {"nol", "satu","dua","tiga","empat","lima","enam","tujuh","depalapan","sembilan","sepuluh"};
		
		if (tambah < 11) {
			model.addAttribute("hasil", tambah);
			model.addAttribute("hasilstring", num[tambah]);
		} else {
			model.addAttribute("hasilstring", "calcuconvert hanya bekerja pada penjumlahan bil bulat, yang hasilnya maks. 10");
		}
		return "calcuconvert";
	}
}

