package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class calculatorController {
	
	@RequestMapping(value = "calculator", method=RequestMethod.GET)
	public ModelAndView goPage(@RequestParam("angka1") String angka1, @RequestParam("angka2") String angka2, Model model) {
	    ModelAndView mav = new ModelAndView("calculator");
	    mav.addObject("angka1", angka1);
	    mav.addObject("angka2", angka2);
	    
	    int res = Integer.parseInt(angka1) + Integer.parseInt(angka2);
	    mav.addObject("res",res);
	    
        String[] ribu = {"", " Seribu", " Dua Ribu", " Tiga Ribu", " Empat Ribu", " Lima Ribu", " Enam Ribu", " Tujuh Ribu", " Delapan Ribu", " Sembilan Ribu"};
        String[] ratus = {"", " Seratus", " Dua Ratus", " Tiga Ratus", " Empat Ratus", " Lima Ratus", " Enam Ratus", " Tujuh Ratus", " Delapan Ratus", " Sembilan Ratus"};
        String[] puluh = {"", " Belas", " Dua Puluh", " Tiga Puluh", " Empat Puluh", " Lima Puluh", " Enam Puluh", " Tujuh Puluh", " Delapan Puluh", " Sembilan Puluh"};
        String[] satuan = {"", " Satu", " Dua", " Tiga", " Empat", " Lima", " Enam", " Tujuh", " Delapan", " Sembilan"};
        int pribu = 0, pratus = 0, ppuluh=0, psatuan=0;
        String terbilang = "";
   
        //Konversi angka menjadi terbilang
        if (res < 9999 && res > 0) {
        	
        	pribu = res / 1000;
         	pratus = (res % 1000) / 100;
        	ppuluh = (res % 100) / 10;
        	psatuan = res % 10;
        	
        	if (psatuan == 1) {
        		terbilang = ribu[pribu] + ratus[pratus] +" Se" + puluh[ppuluh];
        		mav.addObject("terbilang", terbilang);
        	
        		}else {
        		terbilang = ribu[pribu] + ratus[pratus] +  puluh[ppuluh] + satuan[psatuan];
        		mav.addObject("terbilang", terbilang);}
        		
        	
        	}else {
        	terbilang = ribu[pribu] + ratus[pratus] + puluh[ppuluh];
        	mav.addObject("terbilang", terbilang);
        	}
   
            
	    return mav;
        }
}
	
