package com.apap.TA.controller;

import com.apap.TA.model.KebutuhanReagenModel;
import com.apap.TA.model.LabSuppliesModel;
import com.apap.TA.service.KebutuhanReagenService;
import com.apap.TA.service.StokLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class ReagenController {

    @Autowired
    private KebutuhanReagenService reagenService;
    
    @Autowired
    private StokLabService labSuppliesService;
    
 // untuk menambah perencanaan kebutuhan reagen
    @RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.GET)
    private String tambahKebutuhan(Model model) {
    	List<LabSuppliesModel> listStok = labSuppliesService.getAllStokLab();
    	List<LabSuppliesModel> listReagen = new ArrayList<LabSuppliesModel>();
    	for(LabSuppliesModel stok : listStok) {
    		if (stok.getJenisBarang().equalsIgnoreCase("Reagen")) {
    			listReagen.add(stok);
    		}
    	}
        model.addAttribute("listReagen", listReagen);
        model.addAttribute("kebutuhan", new KebutuhanReagenModel());
        return "add-kebutuhan";
    }

    @RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.POST)
    private String tambahKebutuhanSubmit(@ModelAttribute KebutuhanReagenModel kebutuhan, @ModelAttribute("itemReagen") LabSuppliesModel itemReagen, Model model) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        kebutuhan.setTanggal_update(date);

        System.out.println("---------------------------> " + itemReagen);
        kebutuhan.setLab_supplies(itemReagen);
        reagenService.addKebutuhan(kebutuhan);
        return "add";
    }
    @RequestMapping(value = "/lab/kebutuhan", method = RequestMethod.GET)
    private String view(Model model) {
        List<KebutuhanReagenModel> list = reagenService.getAllKebutuhanReagen();
        model.addAttribute("reagen", list);
        return "view-reagen";
    }

    @RequestMapping(value = "/lab/kebutuhan/ubah/{id}", method = RequestMethod.GET)
    private String updateReagen(@PathVariable(value = "id") Long id, Model model) {
        KebutuhanReagenModel temp = reagenService.getDetail(id).get();
        model.addAttribute("reagen", temp);
        return "update-kebutuhan-reagen";
    }

    @RequestMapping(value = "/lab/kebutuhan/ubah", method = RequestMethod.POST)
    private String updateReagen(@ModelAttribute KebutuhanReagenModel reagen, Model model) {
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        reagen.setTanggal_update(date);
        reagen.setJumlah(reagenService.getDetail(reagen.getId()).get().getJumlah());
        reagen.setLab_supplies(reagenService.getDetail(reagen.getId()).get().getLab_supplies());
        reagenService.addKebutuhan(reagen);
        return "update";
    }

}
