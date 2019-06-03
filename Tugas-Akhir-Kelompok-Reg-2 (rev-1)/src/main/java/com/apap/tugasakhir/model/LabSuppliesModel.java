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
import javax.validation.constraints.Size;

@Entity
@Table(name = "lab_supplies")
public class LabSuppliesModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "jenis", nullable = false)
	private String jenis;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "deskripsi", nullable = false)
	private String deskripsi;
	
	@NotNull
	@Column(name = "jumlah", nullable = false)
	private int jumlah;
	
	@OneToMany(mappedBy ="idReagen", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<KebutuhanReagenModel> suppliesReagen;
	
	@OneToMany(mappedBy="idSupplies", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<JenisModel> suppliesJenisPemeriksaan;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public List<KebutuhanReagenModel> getSuppliesReagen() {
		return suppliesReagen;
	}

	public void setSuppliesReagen(List<KebutuhanReagenModel> suppliesReagen) {
		this.suppliesReagen = suppliesReagen;
	}
	
	public List<JenisModel> getSuppliesJenisPemeriksaan() {
		return suppliesJenisPemeriksaan;
	}

	public void setSuppliesJenisPemeriksaan(List<JenisModel> suppliesJenisPemeriksaan) {
		this.suppliesJenisPemeriksaan = suppliesJenisPemeriksaan;
	}
	
}
