package com.apap.tugasakhir.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pemeriksaan")
public class PemeriksaanModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "tanggal_pengajuan", nullable = false)
	private Date tanggalPengajuan;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pasien", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PasienModel pasien;
	
	@Column(name = "tanggal_pemeriksaan")
	private Date tanggalPemeriksaan;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jenis_pemeriksaan", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private JenisModel jenis;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jadwal", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private JadwalJagaModel idJadwal;
	
	@NotNull
	@Column(name = "status", nullable = false)
	private int status;

	@Size(max=255)
	@Column(name = "hasil")
	private String hasil;

	public PasienModel getPasien() {
		return pasien;
	}

	public void setPasien(PasienModel pasien) {
		this.pasien = pasien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}

	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}


	public Date getTanggalPemeriksaan() {
		return tanggalPemeriksaan;
	}

	public void setTanggalPemeriksaan(Date tanggalPemeriksaan) {
		this.tanggalPemeriksaan = tanggalPemeriksaan;
	}

	public JenisModel getJenis() {
		return jenis;
	}

	public void setJenis(JenisModel jenis) {
		this.jenis = jenis;
	}

	public JadwalJagaModel getIdJadwal() {
		return idJadwal;
	}

	public void setIdJadwal(JadwalJagaModel idJadwal) {
		this.idJadwal = idJadwal;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHasil() {
		return hasil;
	}

	public void setHasil(String hasil) {
		this.hasil = hasil;
	}
	
	
}
