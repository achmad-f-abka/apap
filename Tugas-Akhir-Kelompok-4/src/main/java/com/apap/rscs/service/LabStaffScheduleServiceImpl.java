package com.apap.rscs.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.rscs.model.LabStaffScheduleModel;
import com.apap.rscs.repository.StaffScheduleDb;

@Service
@Transactional
public class LabStaffScheduleServiceImpl implements LabStaffScheduleService {
	@Autowired
	StaffScheduleDb staffScheduleDb;

	@Override
	public LabStaffScheduleModel addLabStaffSchedule(LabStaffScheduleModel staffSchedule) {
		return staffScheduleDb.save(staffSchedule);
	}

	@Override
	public List<LabStaffScheduleModel> getAllSchedule() {
		List<LabStaffScheduleModel> listSchedule = (List<LabStaffScheduleModel>) staffScheduleDb.findAll();
		return listSchedule;
	}

	@Override
	public LabStaffScheduleModel getById(Long id) {
		return staffScheduleDb.getOne(id);
	}

	@Override
	public void update(LabStaffScheduleModel staffScheduleModel) {
		staffScheduleDb.save(staffScheduleModel);
		
	}

	@Override
	public List<LabStaffScheduleModel> getAllScheduleByDate(Date scheduleDate) {
		return staffScheduleDb.findByScheduleDate(scheduleDate);
		
	}



}
