package com.apap.tugasakhir.service;

import java.util.List;

import com.apap.tugasakhir.model.StaffModel;

public interface StaffService {
	StaffModel addStaff(StaffModel staf);
	List<StaffModel> getAllStaff();

}
