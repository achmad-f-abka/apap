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
	public String hello2(@RequestParam(value = "name") String name, Model model){
		model.addAttribute("name", name);
		return "hello2";
	}
	
	@RequestMapping(value= {"/hello2","/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name, Model model){
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}

	@RequestMapping("/kalkulator")
    public String perkalian(@RequestParam(value = "s",  defaultValue = "0") int s,
                            @RequestParam(value = "r", defaultValue = "0") int r, Model model) {
        model.addAttribute("s", s);
        model.addAttribute("r", r);
        model.addAttribute("result", s + r);

        String[] thousands = { "", " Seribu", " Dua Ribu", " Tiga Ribu", " Empat Ribu", " Lima Ribu", " Enam Ribu",
                          " Tujuh Ribu", " Delapan Ribu", " Sembilan Ribu" };
        String[] hundreds= { "", " Seratus", " Dua Ratus", " Tiga Ratus", " Empat Ratus", " Lima Ratus", " Enam Ratus",
                           " Tujuh Ratus", " Delapan Ratus", " Sembilan Ratus" };
        String[] dozens = { "", " Belas", " Dua Puluh", " Tiga Puluh", " Empat Puluh", " Lima Puluh", " Enam Puluh",
                           " Tujuh Puluh", " Delapan Puluh", " Sembilan Puluh" };
        String[] number = { "", " Satu", " Dua", " Tiga", " Empat", " Lima", " Enam", " Tujuh", " Delapan", " Sembilan", " Sepuluh" };

        int result = s + r;
        if (result < 9999 && result > 0) {
            int cmath, tzinf, netrc, inflecto;
            cmath= result / 1000;
            tzinf= (result % 1000) / 100;
            netrc= (result % 100) / 10;
            inflecto= result % 10;
            if (netrc== 1) {
                if (inflecto== 1) {
                    model.addAttribute("words", thousands[cmath] + hundreds[tzinf] + " Se" + dozens[netrc]);
                } else {
                    model.addAttribute("words", thousands[cmath] + hundreds[tzinf] + number[inflecto] + dozens[netrc]);
                } 
            } else {
                model.addAttribute("words", thousands[cmath] + hundreds[tzinf] + dozens[netrc] + number[inflecto]);
            }
        } else {
            model.addAttribute("words", "Converter hanya bekerja pada angka dibawah 10 Ribu");
        }
        return "kalkulator";
    }
	
}
