package com.apap.rscs.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.apap.rscs.model.StaffModel;
import com.apap.rscs.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;
		 
	
	@RequestMapping(value = "/staff/tambah", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("staff", new StaffModel());
        return "addStaff";
    }
	
	@RequestMapping(value = "/staff/tambah", method = RequestMethod.POST)
    private RedirectView addStaffSubmit(@ModelAttribute StaffModel staff) {
    	//System.out.println("id_reagen : " + kebutuhanReagen.getLabSupplies().getId());
    	staffService.addStaff(staff);
    	return new RedirectView("/staff");
    }
	
	 @RequestMapping(value = "/staff",method = RequestMethod.GET) 
	 public String frontStaff(Model model){ 
		 List<StaffModel> temp = staffService.getAllStaff();
		 model.addAttribute("staff", temp);
		 return "view-staff";
	}
	
}
