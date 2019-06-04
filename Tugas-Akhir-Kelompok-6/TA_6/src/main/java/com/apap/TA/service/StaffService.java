
package com.apap.TA.service;

import java.util.List;
import java.util.Optional;


import com.apap.TA.model.StaffModel;

public interface StaffService {
	StaffModel addStaff (StaffModel staff);
	List <StaffModel> getAllStaff ();
	Optional <StaffModel> getStaffDetail (Long id);

}
