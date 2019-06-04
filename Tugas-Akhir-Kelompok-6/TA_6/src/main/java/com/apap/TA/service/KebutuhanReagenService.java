package com.apap.TA.service;

import com.apap.TA.model.KebutuhanReagenModel;

import java.util.List;
import java.util.Optional;

public interface KebutuhanReagenService {

    KebutuhanReagenModel addKebutuhan(KebutuhanReagenModel reagen);

    List<KebutuhanReagenModel> getAllKebutuhanReagen();

    Optional<KebutuhanReagenModel> getDetail(Long id);
}
