package com.apap.rscs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.rscs.model.StaffModel;
import com.apap.rscs.repository.StaffDB;

@Service
public class StaffImpl implements StaffService{
	@Autowired
	private StaffDB staffDb;
	
	@Override
	public StaffModel addStaff(StaffModel staff) {
		return staffDb.save(staff);
	}
	
	@Override
	public List<StaffModel> getAllStaff() {
		List<StaffModel> listStaff = (List<StaffModel>) staffDb.findAll();
		return listStaff;
	}
}
