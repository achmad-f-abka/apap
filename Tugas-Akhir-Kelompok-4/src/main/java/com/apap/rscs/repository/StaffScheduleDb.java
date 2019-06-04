package com.apap.rscs.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.rscs.model.LabStaffScheduleModel;

public interface StaffScheduleDb extends JpaRepository<LabStaffScheduleModel, Long> {
	List<LabStaffScheduleModel> findByScheduleDate(Date scheduleDate);
}
