package com.apap.tugasakhir.service;

import com.apap.tugasakhir.model.KebutuhanReagenModel;

import java.util.List;
import java.util.Optional;

public interface KebutuhanReagenService {
	KebutuhanReagenModel addKebutuhanReagen (KebutuhanReagenModel kebutuhanReagen);
	Optional<KebutuhanReagenModel> getKebutuhanReagenById(int id);
	List<KebutuhanReagenModel> getListKebutuhanReagen();
}
