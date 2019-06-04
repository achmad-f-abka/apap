package com.apap.TA.model;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
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

/**
 * StaffModel
 */
@Entity
@Table(name = "staff")
public class StaffModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama_staff", nullable = false)
    private String nama_staff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama_staff() {
        return nama_staff;
    }

    public void setNama_staff(String nama_staff) {
        this.nama_staff = nama_staff;
    }

    @OneToMany (mappedBy="staff", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List <JadwalJagaModel> listJadwal;

	public List<JadwalJagaModel> getListJadwal() {
		return listJadwal;
	}

	public void setListJadwal(List<JadwalJagaModel> listJadwal) {
		this.listJadwal = listJadwal;
	}
    
    
}

