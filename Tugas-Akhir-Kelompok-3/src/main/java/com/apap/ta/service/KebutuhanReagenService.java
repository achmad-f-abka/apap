package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import com.apap.ta.model.KebutuhanReagenModel;

public interface KebutuhanReagenService {
	
	KebutuhanReagenModel addKebutuhanReagen (KebutuhanReagenModel perReagen);
	void deleteKebutuhanReagenById (int id);
	Optional<KebutuhanReagenModel> getKebutuhanReagenById(int id);
	List<KebutuhanReagenModel> getKebutuhanReagenList();
	
}
