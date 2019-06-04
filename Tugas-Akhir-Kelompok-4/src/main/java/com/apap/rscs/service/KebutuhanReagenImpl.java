package com.apap.rscs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.rscs.model.KebutuhanReagenModel;
import com.apap.rscs.repository.KebutuhanReagenDB;

@Service
@Transactional
public class KebutuhanReagenImpl implements KebutuhanReagenService{
	@Autowired
    private KebutuhanReagenDB kebutuhanReagenDb;
	
	@Override
	public KebutuhanReagenModel add(KebutuhanReagenModel kebutuhanReagen) {
		return kebutuhanReagenDb.save(kebutuhanReagen);
	}

	@Override
	public KebutuhanReagenModel getById(Long id) {
		return kebutuhanReagenDb.getOne(id);
	}

	@Override
	public void update(KebutuhanReagenModel kebutuhanReagen) {
		kebutuhanReagenDb.save(kebutuhanReagen);
		
	}

	@Override
	public List<KebutuhanReagenModel> getAll() {
		List <KebutuhanReagenModel> allKebutuhanReagen = (List<KebutuhanReagenModel>) kebutuhanReagenDb.findAll();
		return allKebutuhanReagen;
	}

}
