package com.apap.rscs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.apap.rscs.model.PemeriksaanModel;
import com.apap.rscs.service.PasienService;
import com.apap.rscs.service.PemeriksaanService;

@Controller
public class PemeriksaanController {
    @Autowired
    private PemeriksaanService pemeriksaanService;

    @Autowired
    private PasienService pasienService;

    @RequestMapping(value = "/lab/pemeriksaan/permintaan/tambah", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pasien", pasienService.getAllPasien());
        model.addAttribute("pemeriksaan", new PemeriksaanModel());
        return "add-pemeriksaan-permintaan";
    }

    @RequestMapping(value = "/lab/pemeriksaan/permintaan/tambah", method = RequestMethod.POST)
    private RedirectView addPemeriksaanSubmit(@ModelAttribute PemeriksaanModel permintaanPemeriksaan) {
        pemeriksaanService.addPemeriksaan(permintaanPemeriksaan);
        return new RedirectView("/lab/pemeriksaan/permintaan");
    }

    // Fitur 7
    @RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.GET)
    private String viewPemeriksaan(Model model) {
        List<PemeriksaanModel> temp = pemeriksaanService.getAllPemeriksaan();
        model.addAttribute("pemeriksaan", temp);
		return "view-pemeriksaan-permintaan";
    }

    // Fitur 9
    @RequestMapping(value = "/lab/pemeriksaan/{id}", method = RequestMethod.GET)
    private String update(@PathVariable(value = "id") int id, Model model) {
        PemeriksaanModel pemeriksaan= pemeriksaanService.getPemeriksaanById(id).get();;
		int status = pemeriksaan.getStatus();
		int newStatus=status+1;
		List<Integer> statuses = new ArrayList<Integer>();
		if (status==3) {
			statuses.add(status);}
		else {
			statuses.add(status);
			statuses.add(newStatus);}
		model.addAttribute("pemeriksaan", pemeriksaan);
		model.addAttribute("statuses", statuses);
		return "edit-pemeriksaan-permintaan";
    }

    @RequestMapping(value = "lab/pemeriksaan/permintaan_submit", method = RequestMethod.POST)
    private RedirectView updatedPemeriksaanSubmit(Model model, @ModelAttribute PemeriksaanModel permintaanPemeriksaan) {
        PemeriksaanModel updatePemeriksaan = pemeriksaanService.getById(permintaanPemeriksaan.getId());
        updatePemeriksaan.setId(permintaanPemeriksaan.getId());
		updatePemeriksaan.setTanggal_pengajuan(permintaanPemeriksaan.getTanggal_pengajuan());
		updatePemeriksaan.setTanggal_pemeriksaan(permintaanPemeriksaan.getTanggal_pemeriksaan());
		updatePemeriksaan.setStatus(permintaanPemeriksaan.getStatus());
		updatePemeriksaan.setHasil(permintaanPemeriksaan.getHasil());
        pemeriksaanService.update(permintaanPemeriksaan);
        return new RedirectView("/lab/pemeriksaan/permintaan");
    }

}