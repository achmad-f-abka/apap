package com.apap.tu07.model;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="flight")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FlightModel implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max=50)
	@Column( name = "flight_number", nullable= false)
	private String flightNumber;
	
	@NotNull
	@Size(max=50)
	@Column( name = "origin", nullable= false)
	private String origin;
	
	@NotNull
	@Column( name = "destination", nullable= false)
	private String destination;
	
	@NotNull
	@Column(name="time")
	private Date time;
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pilot_licenseNumber", referencedColumnName = "license_number", nullable = false)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	private PilotModel pilotFlight;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@JsonIgnore
	public PilotModel getPilotFlight() {
		return pilotFlight;
	}

    @JsonProperty("pilotFlight")
	public void setPilotFlight(PilotModel pilotFlight) {
		this.pilotFlight = pilotFlight;
	} 
}