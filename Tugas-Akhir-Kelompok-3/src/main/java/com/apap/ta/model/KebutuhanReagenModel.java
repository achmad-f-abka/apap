package com.apap.ta.model;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "kebutuhan_reagen")
public class KebutuhanReagenModel implements Serializable {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reagen", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LabSuppliesModel reagen;
	
	@NotNull
    @Column(name = "tanggal_update", nullable = false)
    private Date tanggalUpdate;
	
	@NotNull
    @Column(name = "jumlah", nullable = false)
    private int jumlah; 
	
	@NotNull
    @Column(name = "status", nullable = false)
    private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LabSuppliesModel getReagen() {
		return reagen;
	}

	public void setReagen(LabSuppliesModel reagen) {
		this.reagen = reagen;
	}

	public Date getTanggalUpdate() {
		return tanggalUpdate;
	}

	public void setTanggalUpdate(Date tanggalUpdate) {
		this.tanggalUpdate = tanggalUpdate;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	} 
	
	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	
	

}
