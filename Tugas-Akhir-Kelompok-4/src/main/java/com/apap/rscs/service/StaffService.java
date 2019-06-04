package com.apap.rscs.service;

import java.util.List;

import com.apap.rscs.model.StaffModel;

public interface StaffService {
	StaffModel addStaff(StaffModel staff);
	
	List<StaffModel> getAllStaff();
}
