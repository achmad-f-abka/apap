package com.apap.tugasakhir.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.model.PemeriksaanModel;
import com.apap.tugasakhir.service.JadwalJagaService;
import com.apap.tugasakhir.service.JenisPemeriksaanService;
import com.apap.tugasakhir.service.LabService;
import com.apap.tugasakhir.service.LabSuppliesService;
import com.apap.tugasakhir.service.PasienService;
import com.apap.tugasakhir.model.JadwalJagaModel;
import com.apap.tugasakhir.model.JenisModel;
import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.model.PasienModel;


@Controller
public class LabController {
	@Autowired
	private LabService labService;
	
	@Autowired
	private PasienService pasienService;
	
	@Autowired
	private JadwalJagaService jadwalJagaService;
	
	@Autowired
	private JenisPemeriksaanService jenisService;
	
	@Autowired
	private LabSuppliesService labSupplies;
	
	@RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.GET)
	private String view(Model model) {
		List <PemeriksaanModel> listPemeriksaan = labService.findAll();
		System.out.println(listPemeriksaan.size());
		model.addAttribute("listPermintaan", listPemeriksaan);
		return "permintaanPemeriksaanLab";
	}
	
	@RequestMapping(value = "/lab/pemeriksaan/pasien", method = RequestMethod.GET)
	private String viewPasien(Model model) {
		List<PasienModel> listPasien = pasienService.getAllPasien();
		model.addAttribute("listPasien", listPasien);
		return "view-pasien";
	}
	
	@RequestMapping(value = "/lab/pemeriksaan/pasien/{id}", method = RequestMethod.GET)
	private String requestPermintaanForm(@PathVariable(value = "id") Long id, Model model) {
		PasienModel pasien = pasienService.getPasienById(id).get();
		List <JadwalJagaModel> listJadwalJaga = jadwalJagaService.getJadwalAll();
		List <JenisModel> listJenis = jenisService.findAll();
		Date date = new Date(System.currentTimeMillis());
		model.addAttribute("pasien", pasien);
		model.addAttribute("listJadwalJaga", listJadwalJaga);
		model.addAttribute("listJenis", listJenis);
		model.addAttribute("currentDate", date);
		return "permintaanPemeriksaanPasien";
	}
	
	@RequestMapping(value = "/lab/pemeriksaan/pasien/{id}", method = RequestMethod.POST)
	private String submitPermintaanForm(@ModelAttribute PemeriksaanModel jadwalPemeriksaan, @PathVariable(value = "id") Long id) {
		jadwalPemeriksaan.setTanggalPengajuan(new Date(System.currentTimeMillis()));
		jadwalPemeriksaan.setStatus(0);
		jadwalPemeriksaan.setPasien(pasienService.getPasienById(id).get());
		labService.addPermintaan(jadwalPemeriksaan);
		return "home";
	}


	@RequestMapping(value = "/lab/pemeriksaan/permintaan/{id}", method = { RequestMethod.POST })
	 private String updateStatus(@PathVariable(value = "id") int id,
	   @RequestParam(value = "hasil", required = false) String hasil) {
		PemeriksaanModel archive = labService.getPemeriksaanById(id).get();
		JenisModel jenis = archive.getJenis();
		LabSuppliesModel supplies = jenis.getIdSupplies();
		long milis = System.currentTimeMillis();
		Date tanggalPemeriksaan = new Date(milis);
		int jumlah = supplies.getJumlah();
		int status = archive.getStatus();
		if (status != 2 ) {
			status ++;
		}
		if (status == 1 && jumlah >= 1) {
			archive.setTanggalPemeriksaan(tanggalPemeriksaan);
			jumlah -= 1;
			supplies.setJumlah(jumlah);
			archive.setStatus(status);
			labSupplies.addSupplies(supplies);
			labService.addPermintaan(archive);
		}
		
		else if (status == 2) {
			archive.setStatus(status);
			archive.setHasil(hasil);
			labService.addPermintaan(archive);
		}
		return "permintaanPemeriksaanLab";
	}
	
	
}