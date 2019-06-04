package com.apap.TA.service;

import java.util.List;
import java.util.Optional;

import javax.swing.SpinnerModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.apap.TA.model.StaffModel;
import com.apap.TA.repository.StaffDb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffDb staffDb;

	@Override
	public StaffModel addStaff(StaffModel staff) {
		// TODO Auto-generated method stub
		return staffDb.save(staff);
	}

	@Override
	public List<StaffModel> getAllStaff() {
		// TODO Auto-generated method stub
		return staffDb.findAll();
	}

	@Override
	public Optional<StaffModel> getStaffDetail(Long id) {
		// TODO Auto-generated method stub
		return staffDb.findById(id);
	}
	
}
