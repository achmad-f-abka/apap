<<<<<<< HEAD:1606874463/tutorial-05/src/main/java/com/apap/tu05/service/PilotServiceImpl.java
package com.apap.tu05.service;

=======
package com.apap.tu04.service;
import java.util.ArrayList;

import java.util.List;
>>>>>>> 783840336dfa5a0b1dd9f46e09339c4bbc4a861f:1606874482/tutorial-04/src/main/java/com/apap/tu04/service/PilotServiceImpl.java
import java.util.Optional;



import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.PilotDb;

@Service
@Transactional

public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber (String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot (PilotModel pilot) {
		pilotDb.save(pilot);
	}

	@Override
	public void deletePilot(long id) {
		pilotDb.deleteById(id);
		
	}
	
	@Override
	public Optional<PilotModel> getPilotById(long id) {
		return pilotDb.findById(id);
		
	}

}