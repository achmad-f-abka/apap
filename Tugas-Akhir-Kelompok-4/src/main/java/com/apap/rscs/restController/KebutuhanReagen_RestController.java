package com.apap.rscs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.rscs.model.KebutuhanReagenModel;
import com.apap.rscs.service.KebutuhanReagenService;


@RestController
public class KebutuhanReagen_RestController {
	@Autowired
	private KebutuhanReagenService kebutuhanReagenService;
	
	@Autowired
    RestTemplate restTemplate;
	
	@Bean
    public RestTemplate rest() {
    	return new RestTemplate();
    }

	@GetMapping(value="/lab/kebutuhan/perencanaan")
    public List<KebutuhanReagenModel> allKebutuhanReagen() {
    	List<KebutuhanReagenModel> listKebutuhanReagen = kebutuhanReagenService.getAll();
    	return listKebutuhanReagen;
    }
}
