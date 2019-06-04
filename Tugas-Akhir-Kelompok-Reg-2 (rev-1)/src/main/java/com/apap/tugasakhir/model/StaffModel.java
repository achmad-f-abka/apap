package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "staff")
public class StaffModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	

	@OneToMany(mappedBy="staff", fetch=FetchType.LAZY, cascade=CascadeType.ALL)

	private List<JadwalJagaModel> jadwalJagaModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JadwalJagaModel> getJadwalJagaModel() {
		return jadwalJagaModel;
	}

	public void setJadwalJagaModel(List<JadwalJagaModel> jadwalJagaModel) {
		this.jadwalJagaModel = jadwalJagaModel;
	}
	

}
