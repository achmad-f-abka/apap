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

import com.example.demo.model.HalamanCalculator;

@Controller
public class CalculatorController {
    @RequestMapping(value="/numberCalculator", method = RequestMethod.GET)
    public String getHalamanKalkulator(){
        return "numberCalculator";
    }
    @RequestMapping(value="/numberCalculator", method = RequestMethod.POST)
    public String proses(@RequestParam("angka1")int ang_satu, @RequestParam("angka2")int ang_dua, @ModelAttribute (name = "prosesKalkulasi") HalamanCalculator prosesKalkulasi, ModelMap model){
    	prosesKalkulasi.setAngka_satu(ang_satu);
    	prosesKalkulasi.setAngka_dua(ang_dua);
    	model.addAttribute("satu", prosesKalkulasi.getAngka_satu());
    	model.addAttribute("dua", prosesKalkulasi.getAngka_satu());
    	
    	int hasil = prosesKalkulasi.proses(ang_satu, ang_dua);
    	model.addAttribute("hasil", hasil);
    	
    	String terbilang = prosesKalkulasi.terbilang(hasil);
    	model.addAttribute("terbilang", terbilang);
        return "numberCalculator";        
    } 
    
    
//    @RequestMapping(value={"/hello2", "/hello2/{name}"})
//    public String helloPath(@PathVariable
//           Optional<String> name, Model model){
//        if (name.isPresent()){
//            model.addAttribute("name", name.get());
//        }else{
//            model.addAttribute("name", "Phoenix");
//        }        
//        return "hello2";
//    }
}
