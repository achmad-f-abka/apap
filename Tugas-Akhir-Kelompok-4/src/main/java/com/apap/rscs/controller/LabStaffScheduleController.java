package com.apap.rscs.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.apap.rscs.model.LabStaffScheduleModel;
import com.apap.rscs.service.LabStaffScheduleService;
import com.apap.rscs.service.StaffService;

@Controller
public class LabStaffScheduleController {
	@Autowired
    private LabStaffScheduleService labStaffScheduleService;
	
	@Autowired
    private StaffService staffService;

    @RequestMapping(value = "/lab/jadwal-jaga/tambah", method = RequestMethod.GET)
    private String add(Model model) {
    	model.addAttribute("staff", staffService.getAllStaff());
        model.addAttribute("staffSchedule", new LabStaffScheduleModel());
        return "add-lab-staff-schedule";
    }

    @RequestMapping(value = "/lab/jadwal-jaga/tambah", method = RequestMethod.POST)
    private RedirectView addLabStaffScheduleSubmit(@ModelAttribute LabStaffScheduleModel staffScheduleModel) {
    	
    	labStaffScheduleService.addLabStaffSchedule(staffScheduleModel);
    	return new RedirectView("/lab/jadwal");
    }
    
   /* @RequestMapping(value = "/lab/jadwal-jaga", method = RequestMethod.GET)
    private String viewSchedule(Model model) {
        List<LabStaffScheduleModel> temp = labStaffScheduleService.getAllSchedule();
        model.addAttribute("staffSchedule", temp);
        return "view-lab-staff-schedule";
    }*/
    
    @RequestMapping(value = "/lab/jadwal")
    private String viewScheduleByDate(Model model) {
        List<LabStaffScheduleModel> temp = labStaffScheduleService.getAllSchedule();
        model.addAttribute("staffSchedule", temp);
        return "view-lab-staff-schedule";
    }
    
    //Fitur 11
    @RequestMapping(value = "/lab/jadwal-jaga/{scheduleDate}", method = RequestMethod.GET)
    private String viewScheduleByDate(Model model, @PathVariable(value = "scheduleDate") Date scheduleDate) {
    	List<LabStaffScheduleModel> staffSchedule= labStaffScheduleService.getAllScheduleByDate(scheduleDate);
    	
    	System.out.println(staffSchedule);
    	
    	model.addAttribute("staffSchedule", staffSchedule);
    	return "view-lab-staff-schedule-byDate";
    }
    
    @RequestMapping(value = "/lab/jadwal-jaga/", method = RequestMethod.GET)
    private String viewScheduleByDate2(Model model, @RequestParam(value = "scheduleDate") Date scheduleDate) {
    	List<LabStaffScheduleModel> staffSchedule= labStaffScheduleService.getAllScheduleByDate(scheduleDate);
    	System.out.println(staffSchedule);
    	model.addAttribute("staffSchedule", staffSchedule);
    	return "view-lab-staff-schedule-byDate";
    }
    
    
    //Fitur 12
    @RequestMapping(value = "/lab/jadwal-jaga/ubah/{id}", method = RequestMethod.GET)
    private String update(@PathVariable(value = "id") Long id, Model model) {
    	LabStaffScheduleModel staffSchedule = labStaffScheduleService.getById(id);
    	model.addAttribute("staff", staffService.getAllStaff());
        model.addAttribute("upStaffShedule", staffSchedule);
        return "edit-lab-staff-schedule";
    }

    @RequestMapping(value = "/lab/jadwal-jaga/ubah", method = RequestMethod.POST)
    private RedirectView updatedScheduleSubmit(Model model, RedirectAttributes ra, @ModelAttribute LabStaffScheduleModel staffScheduleModel) {
    	LabStaffScheduleModel updateSchedule= labStaffScheduleService.getById(staffScheduleModel.getId());
        updateSchedule.setId(staffScheduleModel.getId());
        updateSchedule.setDate(staffScheduleModel.getDate());
        updateSchedule.setStartTime(staffScheduleModel.getStartTime());
        updateSchedule.setEndTime(staffScheduleModel.getEndTime());
        updateSchedule.setStaff(staffScheduleModel.getStaff());
        labStaffScheduleService.update(staffScheduleModel);
        ra.addAttribute("date", staffScheduleModel.getDate());
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/lab/jadwal-jaga/{date}");
        return rv;
    }

}
