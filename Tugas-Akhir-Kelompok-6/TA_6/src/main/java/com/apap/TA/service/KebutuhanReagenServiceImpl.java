package com.apap.TA.service;

import com.apap.TA.model.KebutuhanReagenModel;
import com.apap.TA.repository.KebutuhanReagenDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KebutuhanReagenServiceImpl implements KebutuhanReagenService {
    @Autowired
    private KebutuhanReagenDb reagenModel;

    @Override
    public KebutuhanReagenModel addKebutuhan(KebutuhanReagenModel reagen) {
        return reagenModel.save(reagen);
    }

    @Override
    public List<KebutuhanReagenModel> getAllKebutuhanReagen() {
        return reagenModel.findAll();
    }

    @Override
    public Optional<KebutuhanReagenModel> getDetail(Long id) {
        return reagenModel.findById(id);
    }
}
