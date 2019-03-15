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
	public String hello2(@RequestParam(value="name")String name, Model model) {
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
	
		@RequestMapping("/numberCalculator")
	
	    public String perkalian(@RequestParam(value = "x", required = false, defaultValue = "0") int x,
	                            @RequestParam(value = "y", required = false, defaultValue = "0") int y, Model model) {
	                           
	        model.addAttribute("x", x);
	        model.addAttribute("y", y);
	        model.addAttribute("hasil", x + y);

	        String[] ribuan = { "", " Seribu", " Dua Ribu", " Tiga Ribu", " Empat Ribu", " Lima Ribu", " Enam Ribu",
	                          " Tujuh Ribu", " Delapan Ribu", " Sembilan Ribu" };
	        String[] ratusan= { "", " Seratus", " Dua Ratus", " Tiga Ratus", " Empat Ratus", " Lima Ratus", " Enam Ratus",
	                           " Tujuh Ratus", " Delapan Ratus", " Sembilan Ratus" };
	        String[] belasan = { "", " Belas", " Dua Puluh", " Tiga Puluh", " Empat Puluh", " Lima Puluh", " Enam Puluh",
	                           " Tujuh Puluh", " Delapan Puluh", " Sembilan Puluh" };
	        String[] satuan = { "", " Satu", " Dua", " Tiga", " Empat", " Lima", " Enam", " Tujuh", " Delapan", " Sembilan", " Sepuluh" };

	        int hasil = x + y;
	        if (hasil < 9999 && hasil > 0) {
	            int ribu, ratus, belas, satu;
	            ribu= hasil / 1000;
	            ratus= (hasil % 1000) / 100;
	            belas= (hasil % 100) / 10;
	            satu= hasil % 10;
	            if (belas== 1) {
	                if (satu== 1) {
	                    model.addAttribute("words", ribuan[ribu] + ratusan[ratus] + " Se" + belasan[belas]);
	                } else {
	                    model.addAttribute("words", ribuan[ribu] + ratusan[ratus] + satuan[satu] + belasan[belas]);
	                } 
	            } else {
	                model.addAttribute("words", ribuan[ribu] + ratusan[ratus] + belasan[belas] + satuan[satu]);
	            }
	        } 
	        return "numberCalculator";
	    }
}
