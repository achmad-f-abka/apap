package com.apap.TA.controller;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.model.JenisPemeriksaanModel;
import com.apap.TA.model.PasienModel;
import com.apap.TA.model.PemeriksaanModel;
import com.apap.TA.service.JadwalJagaService;
import com.apap.TA.service.JenisPemeriksaanService;
import com.apap.TA.service.PasienService;
import com.apap.TA.service.PemeriksaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
public class PemeriksaanController {

    @Autowired
    private PemeriksaanService periksaService;
    
    @Autowired
    private PasienService pasienService;
    
    @Autowired
    private JadwalJagaService jagaService;
    
    @Autowired
    private JenisPemeriksaanService jenisService;

    @RequestMapping(value = "/lab/pemeriksaan/pasien", method = RequestMethod.GET)
    private String viewPasien(Model model) {
        List<PasienModel> list = pasienService.getAllPasien();
        model.addAttribute("pasien", list);
        return "view-pasien";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan", method = RequestMethod.GET)
    private String viewJadwal(Model model) {
        List<PemeriksaanModel> list = periksaService.getAllJadwal();
        model.addAttribute("jadwal", list);
        return "view-pemeriksaan";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan/permintaan/pasien/{id}", method = RequestMethod.GET)
    private String addJadwal(@PathVariable(value = "id") Long id, Model model) {
        PasienModel pas = pasienService.getDetail(id).get();
        List<JenisPemeriksaanModel> listJ = jenisService.getAllJenis();
        List<JadwalJagaModel> listM = jagaService.getAllJadwal();
        model.addAttribute("pasien", pas);
        model.addAttribute("jenis", listJ);
        model.addAttribute("jaga", listM);
        return "add-pemeriksaan";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan/permintaan/pasien/{id}", method = RequestMethod.POST)
    private String addJadwal(@ModelAttribute PemeriksaanModel periksa, PasienModel pas, JadwalJagaModel jag, Model model) {
    	periksa.setJadwal_jaga(periksaService.getDetail(periksa.getId()).get().getJadwal_jaga());
    	periksa.setHasil(periksaService.getDetail(periksa.getId()).get().getHasil());
    	periksa.setJenis_pemeriksaan(periksaService.getDetail(periksa.getId()).get().getJenis_pemeriksaan());
    	periksaService.addJadwal(periksa);
        return "add";

    }
    
    @RequestMapping(value = "/lab/pemeriksaan/ubah/{id}", method = RequestMethod.GET)
    private String updateJadwal(@PathVariable(value = "id") Long id, Model model) {
        PemeriksaanModel temp = periksaService.getDetail(id).get();
        model.addAttribute("jadwal", temp);
        return "update-pemeriksaan";
    }
    
    @RequestMapping(value = "/lab/pemeriksaan/ubah", method = RequestMethod.POST)
    private String updateJadwal(@ModelAttribute PemeriksaanModel periksa, Model model) {
    	periksa.setJadwal_jaga(periksaService.getDetail(periksa.getId()).get().getJadwal_jaga());
    	periksa.setTanggal_pengajuan(periksaService.getDetail(periksa.getId()).get().getTanggal_pengajuan());
    	periksa.setTanggal_pemeriksaan(periksaService.getDetail(periksa.getId()).get().getTanggal_pemeriksaan());
    	periksa.setJenis_pemeriksaan(periksaService.getDetail(periksa.getId()).get().getJenis_pemeriksaan());
    	periksa.setPasien(periksaService.getDetail(periksa.getId()).get().getPasien());
        periksaService.addJadwal(periksa);
        return "update";
    }

}