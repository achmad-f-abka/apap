package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.KebutuhanReagenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KebutuhanReagenDb extends JpaRepository<KebutuhanReagenModel, Integer> {
	Optional<KebutuhanReagenModel> findByIdReagen(int idReagen);

}
