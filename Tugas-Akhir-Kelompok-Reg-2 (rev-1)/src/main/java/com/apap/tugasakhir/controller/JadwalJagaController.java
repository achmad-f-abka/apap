package com.apap.tugasakhir.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tugasakhir.model.JadwalJagaModel;
import com.apap.tugasakhir.model.StaffModel;
import com.apap.tugasakhir.service.JadwalJagaService;
import com.apap.tugasakhir.service.StaffService;


@Controller
@RequestMapping("/lab/jadwal-jaga")
public class JadwalJagaController {
	@Autowired
	private JadwalJagaService jadwalJagaService;
	
	@Autowired
	public StaffService staffService;
	
	
	@RequestMapping(value = "/tambah", method = RequestMethod.GET)
    private String add(Model model) {
		
		JadwalJagaModel jadwal = new JadwalJagaModel();
		List<StaffModel> staffList = staffService.getAllStaff();
		model.addAttribute("jadwal_jaga", jadwal);
		model.addAttribute("staffList", staffList);	
	
		
        return "addJadwal";
    }
	
	@RequestMapping(value="/tambah", method=RequestMethod.POST)
	private String addJadwalSubmit(@ModelAttribute JadwalJagaModel jadwalJaga) {
		jadwalJagaService.addJadwal(jadwalJaga);
		return "add";
	}
	
	@RequestMapping(value="/{tanggal}", method = RequestMethod.GET)
	private String viewJadwal(@PathVariable(value = "tanggal") Date tanggal, Model model) {

		
		List<StaffModel> staffList = staffService.getAllStaff();
		List<JadwalJagaModel> jadwal = new ArrayList();
		for (int i = 0; i <= staffList.size()-1; i++) {
			for (int j = 0; j <= staffList.get(i).getJadwalJagaModel().size()-1; j++) {
				Date tanggalStaff = staffList.get(i).getJadwalJagaModel().get(j).getTanggal();
				if (tanggalStaff.equals(tanggal)) {
					jadwal.add(staffList.get(i).getJadwalJagaModel().get(j));
					
				}
				
			}
		}
		model.addAttribute("jadwal", jadwal);
		model.addAttribute("jadwal1", jadwal.get(0));

		return "viewJadwal";
		
	}
	
	@RequestMapping(value="/ubah/{id}", method = RequestMethod.GET)
	private String update(@PathVariable(value = "id") long id, Model model) {
		Optional<JadwalJagaModel> jadwal = jadwalJagaService.getJadwalById(id);

		List<StaffModel> staffList = staffService.getAllStaff();
		model.addAttribute("jadwal", jadwal.get());
		model.addAttribute("staffList", staffList);

		return "updateJadwal";
		
	}
	@RequestMapping(value = "/ubah", method = RequestMethod.POST)
    private String updateSubmit(@ModelAttribute JadwalJagaModel jadwal, Model model) {
        jadwalJagaService.addJadwal(jadwal);

        List<StaffModel> staffList = staffService.getAllStaff();
		List<JadwalJagaModel> jadwal1 = new ArrayList();
		for (int i = 0; i <= staffList.size()-1; i++) {
			for (int j = 0; j <= staffList.get(i).getJadwalJagaModel().size()-1; j++) {
				Date tanggalStaff = staffList.get(i).getJadwalJagaModel().get(j).getTanggal();
				if (tanggalStaff.equals(jadwal.getTanggal())) {
					jadwal1.add(staffList.get(i).getJadwalJagaModel().get(j));
					
				}
				
			}
		}
		model.addAttribute("jadwal", jadwal1);
		model.addAttribute("jadwal1", jadwal1.get(0));        
		return "viewJadwal";

    }
	
	

}
