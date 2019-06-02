package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import com.apap.ta.model.StaffModel;

public interface StaffService {
	
	StaffModel addStaff(StaffModel staff);
	void deleteStaffById(int id);
	Optional<StaffModel> getStaffById(int id);
	List<StaffModel> getStaffList();

}
