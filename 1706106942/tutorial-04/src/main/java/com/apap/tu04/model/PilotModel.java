package com.apap.tu04.model;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pilot")

public class PilotModel implements Serializable {
//	public PilotModel(String licenseNumber, String name, int flyHour, FlightModel... flights) {
//		this.name = name;
//		this.licenseNumber = licenseNumber;
//		this.flyHour = flyHour;
//        this.pilotFlight = Stream.of(pilotFlight).collect(Collectors.toSet());
//        this.books.forEach(x -> x.setBookCategory(this));
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "licenseNumber", nullable = false, unique = true)
	private String licenseNumber;
	
	@NotNull
	@Column(name = "flyHour", nullable = false)
	private int flyHour;
	
	@OneToMany(mappedBy = "pilot", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<FlightModel> pilotFlight;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
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
