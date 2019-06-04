package com.apap.TA.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.model.StaffModel;
import com.apap.TA.service.JadwalJagaService;
import com.apap.TA.service.StaffService;

@Controller
public class JadwalJagaController {
	@Autowired 
	private StaffService staffService;
	
	@Autowired
	private JadwalJagaService jadwalJagaService;
	
	@RequestMapping(value= "/lab/jadwal-jaga/view", method =RequestMethod.GET)
	private String viewStaff (Model model) {
		List <StaffModel> archieveStaff = staffService.getAllStaff();
		model.addAttribute("listStaff", archieveStaff);
		return "view-jadwal";
	}
	@RequestMapping (value="/lab/jadwal-jaga/staff", method=RequestMethod.GET)
	private String addStaff (Model model) {
		model.addAttribute("staff", new StaffModel());
		return "add-staff";
	}
	@RequestMapping(value="lab/jadwal-jaga/staff", method = RequestMethod.POST)
	private String addStaffSubmit (@ModelAttribute StaffModel staff) {
		staffService.addStaff(staff);
		return "add";
	}
	@RequestMapping (value="lab/jadwal-jaga/tambah", method = RequestMethod.GET)
	private String addJadwal (Model model) {
		
		List <StaffModel> archieveStaff = staffService.getAllStaff();
		model.addAttribute("jadwal", new JadwalJagaModel());
		model.addAttribute("listStaff", archieveStaff);
		
		//get todays date and waktuMulai for constrain
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		String nowTime = LocalTime.now().format(dtf);
		model.addAttribute("timeNow", nowTime);
		System.out.println(nowTime);
		LocalDate today = LocalDate.now();
		model.addAttribute("today", today);
		
		return "add-jadwal";
	}
	@RequestMapping (value="lab/jadwal-jaga/tambah", method= RequestMethod.POST)
	private String addJadwalSubmit (@ModelAttribute JadwalJagaModel jadwal, Model model) {
		List<JadwalJagaModel> listJadwal = jadwalJagaService.getAllJadwal();
		
		for(int i = 0; i< listJadwal.size(); i++) {
			JadwalJagaModel jdwl = listJadwal.get(i);
			List<StaffModel> staff = staffService.getAllStaff();
			if(!jadwalJagaService.validateJadwal(jdwl)){
				model.addAttribute("NotValid", "Waktu yang dimasukkan sudah berlalu");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
				String nowTime = LocalTime.now().format(dtf);
				model.addAttribute("timeNow", nowTime);
				System.out.println(nowTime);
				LocalDate today = LocalDate.now();
				model.addAttribute("today", today);
				model.addAttribute("jadwal", jadwal);
				model.addAttribute("staff", staff);
				return "add";
			}
			else {
				System.out.println(jadwalJagaService.validateJadwal(jdwl));
				jadwalJagaService.addJadwal(jadwal);
			}
		}
		
		//jadwalJagaService.addJadwal(jadwal);
		return "redirect:/lab/jadwal-jaga/tambah";
		
	}
	@RequestMapping(value="/lab/jadwal-jaga", method = RequestMethod.GET)
	private String view (@RequestParam(value="tanggal") java.sql.Date tanggal, Model model) {
		//Optional <JadwalJagaModel> archieveJadwal = jadwalJagaService.findByTanggal(tanggal);
		List<JadwalJagaModel> archieveJadwal =jadwalJagaService.findByTanggal(tanggal);
		System.out.println(archieveJadwal.get(0).getStaff().getNama_staff());
		model.addAttribute("jadwal", archieveJadwal);
		return "liat-jadwal-lagi";
	}
	@RequestMapping (value="/lab/jadwal-jaga/ubah", method= RequestMethod.GET)
	private String ubah (@RequestParam(value="id") int id, Model model) {
		JadwalJagaModel archieve = jadwalJagaService.getJadwalDetail(id).get();
		System.out.println(id);
		//date and waktuMulai Constrain
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		String nowTime = LocalTime.now().format(dtf);
		model.addAttribute("timeNow", nowTime);
		LocalDate today = LocalDate.now();
		model.addAttribute("today", today);
		model.addAttribute("jadwal", archieve);
		model.addAttribute("listStaff", staffService.getAllStaff());
		return "update-jadwal";
	}
	@RequestMapping (value="/lab/jadwal-jaga/ubah", method = RequestMethod.POST)
	private String ubahSubmit (@ModelAttribute JadwalJagaModel jadwal, Model model) {
		//jadwalJagaService.addJadwal(jadwal);
	//	StaffModel staff = staffService.getStaffDetail(jadwal.getId()).get();
		
		if(!jadwalJagaService.validateJadwal(jadwal)) {
			model.addAttribute("NotValid", "Waktu yang dimasukkan sudah berlalu");
			model.addAttribute("jadwal", jadwal);
			model.addAttribute("listStaff", staffService.getAllStaff());
			return "update-jadwal";
		}
		else {
			//jadwal.setStaff(staff);
			jadwalJagaService.addJadwal(jadwal);
		}
		java.sql.Date tanggal = jadwal.getTanggal();
		return "redirect:/lab/jadwal-jaga/?tanggal="+tanggal.toString();
		//return "update";
	}

}
