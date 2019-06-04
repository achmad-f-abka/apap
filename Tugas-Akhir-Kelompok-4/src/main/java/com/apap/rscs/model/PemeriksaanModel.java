package com.apap.rscs.model;

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

@Entity
@Table(name = "pemeriksaan")
public class PemeriksaanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;
	
	@NotNull
    @Column(name = "tanggal_pengajuan", nullable = true)
    private Date tanggal_pengajuan;
	
	
	@NotNull
    @Column(name = "tanggal_pemeriksaan", nullable = true)
    private Date tanggal_pemeriksaan;
	
	
	@NotNull
    @Column(name = "status", nullable = true)
    private int status;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "hasil", nullable = false)
	private String hasil;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jenis", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JenisPemeriksaanModel jenis_pemeriksaan;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pasien", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PasienModel pasien;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_scheduleDate", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LabStaffScheduleModel staff_schedule;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTanggal_pengajuan() {
		return tanggal_pengajuan;
	}

	public void setTanggal_pengajuan(Date tanggal_pengajuan) {
		this.tanggal_pengajuan = tanggal_pengajuan;
	}

	public Date getTanggal_pemeriksaan() {
		return tanggal_pemeriksaan;
	}

	public void setTanggal_pemeriksaan(Date tanggal_pemeriksaan) {
		this.tanggal_pemeriksaan = tanggal_pemeriksaan;
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

	public JenisPemeriksaanModel getJenis_pemeriksaan() {
		return jenis_pemeriksaan;
	}

	public void setJenis_pemeriksaan(JenisPemeriksaanModel jenis_pemeriksaan) {
		this.jenis_pemeriksaan = jenis_pemeriksaan;
	}

	public PasienModel getPasien() {
		return pasien;
	}

	public void setPasien(PasienModel pasien) {
		this.pasien = pasien;
	}

	public LabStaffScheduleModel getStaff_schedule() {
		return staff_schedule;
	}

	public void setStaff_schedule(LabStaffScheduleModel staff_schedule) {
		this.staff_schedule = staff_schedule;
	}

}