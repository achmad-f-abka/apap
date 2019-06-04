package com.apap.rscs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.apap.rscs.model.PasienModel;
import com.apap.rscs.service.PasienService;

@Controller
public class PasienController {
	@Autowired
	private PasienService pasienService;
	
	@RequestMapping(value = "/pasien/tambah", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pasien", new PasienModel());
        return "addPasien";
    }
	
	@RequestMapping(value = "/pasien/tambah", method = RequestMethod.POST)
    private RedirectView addPasienSubmit(@ModelAttribute PasienModel pasien) {
    	//System.out.println("id_reagen : " + kebutuhanReagen.getLabSupplies().getId());
    	pasienService.addPasien(pasien);
    	return new RedirectView("/pasien");
    }
	
	 @RequestMapping(value = "/pasien",method = RequestMethod.GET) 
	 public String frontPasien(Model model){ 
		 List<PasienModel> temp = pasienService.getAllPasien();
		 model.addAttribute("pasien", temp);
		 return "view-pasien";
	}
	
	
}
