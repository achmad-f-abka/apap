package com.apap.ta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.ta.model.KebutuhanReagenModel;
import com.apap.ta.repository.KebutuhanReagenDb;

@Service
@Transactional
public class KebutuhanReagenServiceImpl implements KebutuhanReagenService {

	@Autowired
	KebutuhanReagenDb kebutuhanReagenDb;
	
	@Override
	public KebutuhanReagenModel addKebutuhanReagen(KebutuhanReagenModel perReagen) {
		return kebutuhanReagenDb.save(perReagen);
	}

	@Override
	public void deleteKebutuhanReagenById(int id) {
		kebutuhanReagenDb.deleteById(id);
		
	}

	@Override
	public Optional<KebutuhanReagenModel> getKebutuhanReagenById(int id) {
		return kebutuhanReagenDb.findById(id);
	}

	@Override
	public List<KebutuhanReagenModel> getKebutuhanReagenList() {
		return kebutuhanReagenDb.findAll();
		
	}
	
	
	
}
