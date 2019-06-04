package com.apap.rscs.service;

import java.util.List;

import com.apap.rscs.model.KebutuhanReagenModel;

public interface KebutuhanReagenService {
	KebutuhanReagenModel add (KebutuhanReagenModel kebutuhanReagen);
	
	KebutuhanReagenModel getById (Long id);
	
	void update (KebutuhanReagenModel kebutuhanReagen);
	
	List<KebutuhanReagenModel> getAll();
}
