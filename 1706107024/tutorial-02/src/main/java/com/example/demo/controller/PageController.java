package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	private String result;

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value = "name", required = false) String name, Model model) {
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
	
	
	@RequestMapping("/calculator/{firstNum}/{secondNum}")
	public String calculator(@PathVariable int firstNum, @PathVariable int secondNum, Model model) {
			model.addAttribute("firstNum", firstNum);
			model.addAttribute("secondNum", secondNum);
			model.addAttribute("totalSum", firstNum+secondNum);
			int totalSum = firstNum + secondNum;
			model.addAttribute("dibaca", convert(totalSum));
		
		return "calculator";
	}
	
	
	public String convert(@PathVariable Integer angka) {
		String[] satuan = {"","satu","dua","tiga","empat","lima","enam","tujuh","delapan","sembilan"};
		result = " ";
		if (angka == 10) {
			result = " sepuluh";
		} else if (angka == 11) {
			result = " sebelas";
		} else if (angka < 10){
            result = result + satuan[angka];
        } else if (angka>11 && angka < 20){
            result = result + convert(angka-10) + " belas";
        } else if (angka < 100){
            result = result + convert(angka / 10) + " puluh " + convert(angka % 10);
        } else if (angka < 200){
            result = result + "seratus " + convert(angka - 100);
        } else if (angka < 1000){
            result = result + convert(angka / 100) + " ratus "  + convert(angka % 100);
        } else if (angka < 2000){
            result = result + "seribu " + convert(angka - 1000);
        } else{
            result = result + convert(angka / 1000) + " ribu " + convert(angka % 1000);
        }
		return result;
	}
	
	
}
