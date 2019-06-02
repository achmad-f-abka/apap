package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.ta.model.StaffModel;
import com.apap.ta.repository.StaffDb;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDb staffDb;

	@Override
	public StaffModel addStaff(StaffModel staff) {
		return staffDb.save(staff);
	}

	@Override
	public void deleteStaffById(int id) {
		staffDb.deleteById(id);
		
	}

	@Override
	public Optional<StaffModel> getStaffById(int id) {
		return staffDb.findById(id);
	}

	@Override
	public List<StaffModel> getStaffList() {
		return staffDb.findAll();
	}

}
