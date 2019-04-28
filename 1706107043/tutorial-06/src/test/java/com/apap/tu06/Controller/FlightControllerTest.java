package com.apap.tu06.Controller;

import java.sql.Date;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.apap.tu06.controller.FlightController;
import com.apap.tu06.model.FlightModel;
import com.apap.tu06.service.FlightService;
import com.apap.tu06.service.PilotService;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private FlightService flightService;
	
	@MockBean
	private PilotService pilotService;
	
	@Test
	public void givenFlightNumber_whenViewFlight_thenReturnJsonFlight() throws Exception {
		// Given
		FlightModel flight = new FlightModel();
		flight.setFlightNumber("1765");
		flight.setOrigin("Jakarta");
		flight.setDestination("Bali");
		flight.setTime(new Date(new java.util.Date().getTime()));
		Optional<FlightModel> fl = Optional.of(flight);
		Mockito.when(flightService.getFlightDetailByFlightNumber(fl.get().getFlightNumber())).thenReturn(fl);
		
		
		// When
		mvc.perform(MockMvcRequestBuilders.get("/flight/view")
				.param("flightNumber", fl.get().getFlightNumber())
				.contentType(MediaType.APPLICATION_JSON))
		
		// Then
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.flightNumber", Matchers.is(fl.get().getFlightNumber())));
	}
}





















