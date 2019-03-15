package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PageCalculator;

@Controller
public class ControllerCalculator {
    @RequestMapping(value="/numberCalculator", method = RequestMethod.GET)
    public String getPageKalkulator(){
        return "numberCalculator";
    }
    @RequestMapping(value="/numberCalculator", method = RequestMethod.POST)
    public String proses(@RequestParam("bil1")int bilangan1, @RequestParam("bil2")int bilangan2, @ModelAttribute (name = "prosesKalkulasi") PageCalculator prosesKalkulasi, ModelMap model){
    	prosesKalkulasi.setBilanganSatu(bilangan1);
    	prosesKalkulasi.setBilanganDua(bilangan2);
    	model.addAttribute("satu", prosesKalkulasi.getBilanganSatu());
    	model.addAttribute("dua", prosesKalkulasi.getBilanganSatu());
    	
    	int hasil = prosesKalkulasi.proses(bilangan1, bilangan2);
    	model.addAttribute("hasil", hasil);
    	
    	String terbilang = prosesKalkulasi.terbilang(hasil);
    	model.addAttribute("terbilang", terbilang);
        return "numberCalculator";        
    }
}