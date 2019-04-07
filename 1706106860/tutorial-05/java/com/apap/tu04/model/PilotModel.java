package com.apap.tu04.model;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pilot")
public class PilotModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max=50)
	@Column(name="license_number", nullable=false,unique=true)
	private String license_number;
	
	@NotNull
	@Size(max=50)
	@Column(name="name", nullable=false)
	private String name;
	
	@NotNull
	@Column(name="fly_hour", nullable=false)
	private int flyHour;
	
	@OneToMany(mappedBy="pilot", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	private List<FlightModel> pilotFlight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicense_number() {
		return license_number;
	}

	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlyHour() {
		return flyHour;
	}

	public void setFlyHour(int flyHour) {
		this.flyHour = flyHour;
	}

	public List<FlightModel> getPilotFlight() {
		return pilotFlight;
	}

	public void setPilotFlight(List<FlightModel> pilotFlight) {
		this.pilotFlight = pilotFlight;
	}
	
	

}
