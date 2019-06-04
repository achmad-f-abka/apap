package com.apap.TA.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * LabSuppliesModel
 */

@Entity
@Table (name = "lab_supplies")
public class LabSuppliesModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    @NotNull
    @Size(max = 255)
    @Column(name = "jenis_barang", nullable = false)
    private String jenisBarang;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;
    
    @NotNull
    @Column(name = "jumlah_barang", nullable = false)
    private int jumlahBarang;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "deskripsi_barang", nullable = false)
    private String deskripsiBarang;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJenisBarang() {
		return jenisBarang;
	}

	public void setJenisBarang(String jenisBarang) {
		this.jenisBarang = jenisBarang;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public int getJumlahBarang() {
		return jumlahBarang;
	}

	public void setJumlahBarang(int jumlahBarang) {
		this.jumlahBarang = jumlahBarang;
	}

	public String getDeskripsiBarang() {
		return deskripsiBarang;
	}

	public void setDeskripsiBarang(String deskripsiBarang) {
		this.deskripsiBarang = deskripsiBarang;
	}
    
	
	

}


