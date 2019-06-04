package com.apap.rscs.service;

import java.sql.Date;
import java.util.List;

import com.apap.rscs.model.LabStaffScheduleModel;

public interface LabStaffScheduleService {
	LabStaffScheduleModel addLabStaffSchedule(LabStaffScheduleModel staffSchedule);

	List<LabStaffScheduleModel> getAllSchedule();
	
	List<LabStaffScheduleModel> getAllScheduleByDate(Date scheduleDate);

	LabStaffScheduleModel getById(Long id);

	void update(LabStaffScheduleModel staffScheduleModel);
}
