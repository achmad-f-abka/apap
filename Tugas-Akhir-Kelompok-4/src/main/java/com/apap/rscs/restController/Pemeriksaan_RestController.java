package com.apap.rscs.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.rscs.model.PemeriksaanModel;
import com.apap.rscs.service.PemeriksaanService;

@RestController
public class Pemeriksaan_RestController {
	@Autowired
	private PemeriksaanService pemeriksaanService;
	
	@Autowired
    RestTemplate restTemplate;
	
	@Bean public RestTemplate restPemeriksaan(){
		return new RestTemplate(); 
	}
	 
	@PostMapping(path = "/lab/pemeriksaan/permintaan", consumes = "application/json", produces = "application/json")
	public @ResponseBody PemeriksaanModel addPermintaan(@RequestBody PemeriksaanModel pemeriksaan) {
	    pemeriksaanService.addPemeriksaan(pemeriksaan);
	    return pemeriksaan;
	}
}
