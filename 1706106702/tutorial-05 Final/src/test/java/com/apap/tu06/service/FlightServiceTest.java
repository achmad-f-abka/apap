package com.apap.tu06.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.apap.tu06.model.FlightModel;
import com.apap.tu06.repository.FlightDb;

@RunWith(SpringRunner.class)
public class FlightServiceTest {
	@Autowired
	private FlightService flightService;
	
	@MockBean
	private FlightDb flightDb;
	
	@TestConfiguration // Membatasi scope Bean yang didefinisikan menjadi local class
	static class FlightServiceTestContextConfiguration{
		@Bean // Initiate flightService sebagai Bean
		public FlightService flightService() {
			return new FlightServiceImpl();
		}
	}
	
	@Test
	private void whenValidFlightNumber_thenFlightShouldBeFound() {
		// Given
		FlightModel flight = new FlightModel();
		flight.setFlightNumber("1765");
		flight.setOrigin("Jakarta");
		flight.setDestination("Bali");
		flight.setTime(new Date(new java.util.Date().getTime()));
		Optional<FlightModel> fl = Optional.of(flight);
		Mockito.when(flightDb.findByFlightNumber(fl.get().getFlightNumber())).thenReturn(fl);
		
		// When
		Optional<FlightModel> found = flightService.getFlightDetailByFlightNumber(fl.get().getFlightNumber());
		
		// Then
		assertThat(found, Matchers.notNullValue());
		assertThat(found.get().getFlightNumber(), Matchers.equalTo(flight.getFlightNumber())); // Check if same
	}

}