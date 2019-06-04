package com.apap.tugasakhir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.KebutuhanReagenModel;
import com.apap.tugasakhir.repository.KebutuhanReagenDb;

@Service
@Transactional
public class KebutuhanReagenServiceImpl implements KebutuhanReagenService {
	@Autowired
	private KebutuhanReagenDb kebutuhanReagenDb;
	
	@Override
	public KebutuhanReagenModel addKebutuhanReagen(KebutuhanReagenModel kebutuhanReagen) {
		return kebutuhanReagenDb.save(kebutuhanReagen);
	}
	
	@Override
	public Optional<KebutuhanReagenModel> getKebutuhanReagenById(int id){
		return kebutuhanReagenDb.findById(id);
	}
	
	@Override
	public List<KebutuhanReagenModel> getListKebutuhanReagen(){
		return kebutuhanReagenDb.findAll();
	}
	
	

}
