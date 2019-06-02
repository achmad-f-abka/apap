package com.apap.ta.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.apap.ta.model.StaffModel;
import com.apap.ta.service.JadwalJagaService;
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

	@RequestMapping(value="", method = RequestMethod.GET)
	private String lihatJadwal (@RequestParam(value= "tanggal")Date tanggal, Model model) {
		List<JadwalJagaModel> jadwalJaga = jadwalJagaService.getJadwalJagaByTgl(tanggal);
		model.addAttribute("jadwalJaga", jadwalJaga);
		return "viewJadwal.html";
	}
	
	@RequestMapping(value="/ubah", method = RequestMethod.POST)
	private String ubahJadwal(@ModelAttribute JadwalJagaModel jadwalJaga, String wMulai, String wSelesai,int staf_Id, Model model) throws ParseException {
		StaffModel staff = staffService.getStaffById(staf_Id).get();
		jadwalJaga.setIdStaff(staff);
		Time waktuMulai = new Time (formatter.parse(wMulai).getTime());
		Time waktuSelesai = new Time (formatter.parse(wSelesai).getTime());
		jadwalJaga.setWaktuMulai(waktuMulai);
		jadwalJaga.setWaktuSelesai(waktuSelesai);
		jadwalJagaService.addJadwalJaga(jadwalJaga);
		model.addAttribute("jadwalJaga", jadwalJaga);
		model.addAttribute("message", "Data Jadwal Jaga Berhasil Diubah!");
		return "perubahanJadwal.html";
	}
	
	@RequestMapping(value = "/ubah/{id}", method = RequestMethod.GET)
	private String ubahJadwalJaga (@PathVariable(value="id")int id, Model model) {
		JadwalJagaModel jadwalJaga  =  jadwalJagaService.getJadwalJagaById(id).get();
		Date tanggalSekarang = new java.sql.Date(time);
		model.addAttribute("tanggalSekarang", tanggalSekarang);
		List<StaffModel> staffList = staffService.getStaffList();
		model.addAttribute("jadwalJaga", jadwalJaga);
		model.addAttribute("staffList", staffList);
		return "updateJadwal.html";
	}
	
	
	@RequestMapping(value = "/tambah", method = RequestMethod.GET)
	private String tambahJadwal (Model model) {
		List<StaffModel> staffList = staffService.getStaffList();
		JadwalJagaModel jadwalJaga = new JadwalJagaModel();
		Date tanggalSekarang = new java.sql.Date(time);
		model.addAttribute("tanggalSekarang", tanggalSekarang);
		model.addAttribute("staffList", staffList);
		model.addAttribute("jadwalJaga", jadwalJaga);
		return "tambahJadwal.html";
	}
	
	
	@RequestMapping(value="/tambah", method = RequestMethod.POST)
	private String tambah (@ModelAttribute JadwalJagaModel jadwalJaga,int staf_Id, Model model, String wMulai, String wSelesai) throws ParseException {

		Time waktuMulai = new Time (formatter.parse(wMulai).getTime());
		Time waktuSelesai = new Time (formatter.parse(wSelesai).getTime());
		jadwalJaga.setWaktuMulai(waktuMulai);
		jadwalJaga.setWaktuSelesai(waktuSelesai);
		
		StaffModel staff = staffService.getStaffById(staf_Id).get();
		jadwalJaga.setIdStaff(staff);
		jadwalJagaService.addJadwalJaga(jadwalJaga);
		model.addAttribute("message", "Data Jadwal Jaga Berhasil Ditambahkan!");
		return "kelolaJadwal.html";
	}

}
