package com.apap.TA.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.TA.model.JadwalJagaModel;
import com.apap.TA.repository.JadwalJagaDb;
import com.apap.TA.service.JadwalJagaService;

@Service
@Transactional
public class 	JadwalJagaServiceImpl implements JadwalJagaService{
	
	@Autowired
	private JadwalJagaDb jadwalJagaDb;

	@Override
	public JadwalJagaModel addJadwal(JadwalJagaModel jadwal) {
		// TODO Auto-generated method stub
		return jadwalJagaDb.save(jadwal);
	}

	@Override
	public List<JadwalJagaModel> getAllJadwal() {
		// TODO Auto-generated method stub
		return jadwalJagaDb.findAll();
	}

	

	@Override
	public Optional<JadwalJagaModel> getJadwalDetail(int id) {
		// TODO Auto-generated method stub
		return jadwalJagaDb.findById(id);
	}

	@Override
	public List<JadwalJagaModel> findByTanggal(Date tanggal) {
		// TODO Auto-generated method stub
		return jadwalJagaDb.findByTanggal(tanggal);
	}

	@Override
	public boolean validateJadwal(JadwalJagaModel jadwal) {
		// TODO Auto-generated method stub	
		boolean res = true; 
		
		LocalDate today = LocalDate.now();
		java.sql.Date now = java.sql.Date.valueOf(today); 

		java.util.TimeZone tz = java.util.TimeZone.getTimeZone("GMT+7");
		Calendar cl = Calendar.getInstance(tz);
		LocalTime nowTime = LocalTime.now();
		java.sql.Time time = java.sql.Time.valueOf(cl.get(Calendar.HOUR_OF_DAY)+":"+cl.get(Calendar.MINUTE)+":00");

		if (jadwal.getTanggal().equals(now)){
				String timeString = jadwal.getWaktuMulai();
				java.sql.Time timeIn = java.sql.Time.valueOf(timeString+":00");
				System.out.println("TimeIn: "+timeIn.toString() );
				System.out.println("TimeIn: "+time.toString() );
				if(timeIn.before(time)){
					res = false ;
				}
		}
		return res;
	}

}
