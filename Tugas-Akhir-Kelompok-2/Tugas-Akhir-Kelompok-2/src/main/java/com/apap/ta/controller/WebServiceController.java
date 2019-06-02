package com.apap.ta.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apap.ta.model.JadwalJagaModel;
import com.apap.ta.model.JenisPemeriksaanModel;
import com.apap.ta.model.KebutuhanReagenModel;
import com.apap.ta.model.PasienModel;
import com.apap.ta.model.PemeriksaanModel;
import com.apap.ta.service.JadwalJagaService;
import com.apap.ta.service.JenisPemeriksaanService;
import com.apap.ta.service.KebutuhanReagenService;
import com.apap.ta.service.PasienService;
import com.apap.ta.service.PemeriksaanService;

@RestController
public class WebServiceController {
	
	private long time = System.currentTimeMillis();
	Date tanggal = new java.sql.Date(time);
		
	@Autowired KebutuhanReagenService reagenService;
	
	@Autowired PemeriksaanService pemeriksaanService;
	
	@Autowired PasienService pasienService;
	
	@Autowired JadwalJagaService jadwalJagaService;
	
	@Autowired JenisPemeriksaanService jenisPemeriksaanService;
	
	@GetMapping(value ="/lab/kebutuhan/perencanaan")
	public List<KebutuhanReagenModel> kebutuhanReagenList (){
		return reagenService.getKebutuhanReagenList();
	}
	
	@PostMapping(value="/lab/pemeriksaan/permintaan")
	public PemeriksaanModel addPemeriksaan( @RequestBody int namaPasien) {
		PemeriksaanModel pemeriksaan = new PemeriksaanModel();
		PasienModel pasien = pasienService.getPasienById(namaPasien).get();
		JadwalJagaModel jadwal = jadwalJagaService.getJadwalJagaById(1).get();
		JenisPemeriksaanModel jenis = jenisPemeriksaanService.getJenisPemeriksaanById(1).get(); 
		pemeriksaan.setTanggalPengajuan(tanggal);
		pemeriksaan.setTanggalPemeriksaan(tanggal);
		pemeriksaan.setPasien(pasien);
		pemeriksaan.setStatus(1);
		pemeriksaan.setJadwal(jadwal);
		pemeriksaan.setJenis(jenis);
		return pemeriksaanService.addPemeriksaan(pemeriksaan);
	}

}
