package com.apap.tu06.repository;

import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.apap.tu06.model.FlightModel;
import com.apap.tu06.model.PilotModel;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FlightDbTest {
	@Autowired
	public TestEntityManager entityManager;
	
	@Autowired
	public FlightDb flightDb;
	
	@Test
	public void whenFindByFlightNumber_thenReturnFlight() {
		// Given
		PilotModel pilot = new PilotModel();
		pilot.setLicenseNumber("1234");
		pilot.setName("Anto");
		pilot.setFlyHour(50);
		entityManager.persist(pilot);
		entityManager.flush();
		FlightModel flight = new FlightModel();
		flight.setFlightNumber("1765");
		flight.setOrigin("Jakarta");
		flight.setDestination("Bali");
		flight.setTime(new Date(new java.util.Date().getTime()));
		flight.setPilot(pilot);
		entityManager.persist(flight);
		entityManager.flush();
		
		// When
		Optional<FlightModel> found = flightDb.findByFlightNumber(flight.getFlightNumber());
		
		// Then
		assertThat(found.get(), Matchers.notNullValue()); // Check if not null
		assertThat(found.get(), Matchers.equalTo(flight)); // Check if same
	}
}