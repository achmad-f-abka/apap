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
		model.addAttribute("name",name);
		return "hello2";
	}
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})	
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		} else {
			model.addAttribute("name","Phoenix");
		}
		return "hello2";
	}


//Latihan CalculatorConvert
	
	//Calculator ini digunakan untuk penjumlahan dua angka
	//Terdapat parameter berupa dua angka yaitu number1 dan number2

//RequestMapping digunakan untuk menandakan url yang akan digunakan, calculatorpenjumlahan/number1/number2
@RequestMapping(value={"/calculatorpenjumlahan/{number1}/{number2}"})

//Mengubah number1 dan number 2 ke integer 
public String calculatorpenjumlahan(@PathVariable("number1") int number1, @PathVariable("number2") int number2, Model model) {
			
	String[] sebutanAngka = {"Nol", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sembilan", 
							"Sepuluh", "Sebelas", "Dua belas", "Tiga belas", "Empat belas", "Lima belas",
							"Enam belas", "Tujuh belas", "Delapan belas", "Sembilan belas", "Dua puluh", 
							"Dua puluh satu", "Dua puluh dua", "Dua puluh tiga", "Dua puluh empat", "Dua puluh lima",
							"Dua puluh enam", "Dua puluh tujuh", "Dua puluh delapan", "Dua puluh sembilan", "Tiga puluh"};

	//jumlah, berfungsi untuk penjumlahan number1 dan number2 sehingga yang akan tampil pada calculatorpenjumlahan.html merupakan hasil penjumlahan kedua number tersebut.
	int jumlah = number1+number2;
	
	model.addAttribute("huruf", sebutanAngka[jumlah]);
			
	model.addAttribute("jumlah", jumlah);

	return "calculatorpenjumlahan";

		}
	}