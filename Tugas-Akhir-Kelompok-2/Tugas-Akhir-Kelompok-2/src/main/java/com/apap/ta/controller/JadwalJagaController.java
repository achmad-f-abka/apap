package com.apap.ta.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.ta.model.JadwalJagaModel;
import com.apap.ta.model.PemeriksaanModel;
import com.apap.ta.model.StaffModel;
import com.apap.ta.service.JadwalJagaService;
import com.apap.ta.service.PemeriksaanService;
import com.apap.ta.service.StaffService;

@Controller
@RequestMapping("/lab/jadwal-jaga")
public class JadwalJagaController {
	DateFormat formatter = new SimpleDateFormat("HH:mm");
	private long time = System.currentTimeMillis();
	
	@Autowired
	JadwalJagaService jadwalJagaService;
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	PemeriksaanService pemeriksaanService;
	
	@RequestMapping(value = "/tambah", method = RequestMethod.GET)
	private String tambahJadwal (Model model) {
		List<StaffModel> staffList = staffService.getStaffList();
		JadwalJagaModel jadwalJaga = new JadwalJagaModel();
		Date tanggalSekarang = new java.sql.Date(time);
		model.addAttribute("tanggalSekarang", tanggalSekarang);
		model.addAttribute("staffList", staffList);
		model.addAttribute("jadwalJaga", jadwalJaga);
		return "tambah-jadwal";
	}
	
	
	@RequestMapping(value="/tambah", method = RequestMethod.POST)
	private String inputJadwal (@ModelAttribute JadwalJagaModel jadwalJaga,int staffId, Model model, String wmulai, String wselesai) throws ParseException {
		
		
		Time wktmulai = new Time (formatter.parse(wmulai).getTime());
		Time wktselesai = new Time (formatter.parse(wselesai).getTime());
		jadwalJaga.setWaktuMulai(wktmulai);
		jadwalJaga.setWaktuSelesai(wktselesai);
		
		StaffModel staff = staffService.getStaffById(staffId).get();
		jadwalJaga.setIdStaff(staff);
		jadwalJagaService.addJadwalJaga(jadwalJaga);
		model.addAttribute("notif", "Data Berhasil Ditambahkan");
		return "manajemen-jadwal";
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	private String lihatJadwal (@RequestParam(value= "tanggal")Date tanggal, Model model) {
		List<JadwalJagaModel> jadwalJaga = jadwalJagaService.getJadwalJagaByTanggal(tanggal);
		model.addAttribute("jadwalJaga", jadwalJaga);
		return "view-jadwal";
	}
	
	@RequestMapping(value = "/ubah/{id}", method = RequestMethod.GET)
	private String ubahJadwal (@PathVariable(value="id")int id, Model model) {
		JadwalJagaModel jadwalJaga  =  jadwalJagaService.getJadwalJagaById(id).get();
		Date tanggalSekarang = new java.sql.Date(time);
		model.addAttribute("tanggalSekarang", tanggalSekarang);
		List<StaffModel> staffList = staffService.getStaffList();
		model.addAttribute("jadwalJaga", jadwalJaga);
		model.addAttribute("staffList", staffList);
		return "update-jadwal";
	}
	
	@RequestMapping(value="/ubah", method = RequestMethod.POST)
	private String ubahJadwalSubmit(@ModelAttribute JadwalJagaModel jadwalJaga, String wmulai, String wselesai,int staffId, Model model) throws ParseException {
		StaffModel staff = staffService.getStaffById(staffId).get();
		jadwalJaga.setIdStaff(staff);
		Time wktmulai = new Time (formatter.parse(wmulai).getTime());
		Time wktselesai = new Time (formatter.parse(wselesai).getTime());
		jadwalJaga.setWaktuMulai(wktmulai);
		jadwalJaga.setWaktuSelesai(wktselesai);
		jadwalJagaService.addJadwalJaga(jadwalJaga);
		model.addAttribute("jadwalJaga", jadwalJaga);
		return "jadwal-diubah";
	}
	
	@RequestMapping(value="/jadwal-periksa", method=RequestMethod.GET)
	private String viewJadwalPemeriksaan (Model model) {
		List<PemeriksaanModel> listPemeriksaan = pemeriksaanService.getPemeriksaanList();
		model.addAttribute("listPemeriksaan", listPemeriksaan);
		return "jadwal-periksa";
	}
	
	@RequestMapping(value="jadwal-periksa/assign/{id}", method = RequestMethod.GET)
	private String updateJadwalPemeriksaan(@PathVariable(value="id") int id, Model model) {
		PemeriksaanModel pemeriksaan = pemeriksaanService.getPemeriksaanById(id).get();
		List<JadwalJagaModel> listJadwalJaga = jadwalJagaService.getJadwalJagaList();
		model.addAttribute("listJadwalJaga", listJadwalJaga);
		model.addAttribute("pemeriksaan", pemeriksaan);
		return "assign-jadwal";
	}
	@RequestMapping(value="/jadwal-periksa/assign", method=RequestMethod.POST)
	private String updatePemeriksaanSubmit(@ModelAttribute PemeriksaanModel pemeriksaan,int idJadwal, Model model) {
		JadwalJagaModel jadwalJaga = jadwalJagaService.getJadwalJagaById(idJadwal).get();
		pemeriksaan.setJadwal(jadwalJaga);
		pemeriksaanService.addPemeriksaan(pemeriksaan);
		List<PemeriksaanModel> listPemeriksaan = pemeriksaanService.getPemeriksaanList();
		model.addAttribute("listPemeriksaan", listPemeriksaan);
		return "jadwal-periksa";
		
	}
	
	
	
	
	

}
