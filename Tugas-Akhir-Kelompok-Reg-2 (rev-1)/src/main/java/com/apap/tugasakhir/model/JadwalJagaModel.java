
package com.apap.tugasakhir.model;

import java.io.Serializable;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jadwal_jaga")
public class JadwalJagaModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "tanggal", nullable = false)
	private Date tanggal;
	
	@NotNull
	@Column(name = "waktu_mulai", nullable = false)
	private String waktuMulai;
	
	@NotNull
	@Column(name = "waktu_selesai", nullable = false)
	private String waktuSelesai;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_staff", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore

    private StaffModel staff;

	
	//@Column(name = "staf_lab")
	//private Staf stafLab;
	
	@OneToMany(mappedBy="idJadwal", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<PemeriksaanModel> jadwalJagaPemeriksaan;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getWaktuMulai() {
		return waktuMulai;
	}

	public void setWaktuMulai(String waktuMulai) {
		this.waktuMulai = waktuMulai;
	}

	public String getWaktuSelesai() {
		return waktuSelesai;
	}

	public void setWaktuSelesai(String waktuSelesai) {
		this.waktuSelesai = waktuSelesai;
	}

	public StaffModel getStaffModel() {
		return staff;
	}

	public void setStaffModel(StaffModel staffModel) {
		this.staff = staffModel;

	}

	public List<PemeriksaanModel> getJadwalJagaPemeriksaan() {
		return jadwalJagaPemeriksaan;
	}

	public void setJadwalJagaPemeriksaan(List<PemeriksaanModel> jadwalJagaPemeriksaan) {
		this.jadwalJagaPemeriksaan = jadwalJagaPemeriksaan;
	}
	
	//public Staf getStafLab() {
		//return stafLab;
	//}

	//public void setStafLab(Staf staf) {
		//this.stafLab = staf;
	//}

	
}
