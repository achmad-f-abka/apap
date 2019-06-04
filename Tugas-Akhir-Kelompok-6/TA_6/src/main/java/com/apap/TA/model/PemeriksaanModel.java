package com.apap.TA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

/**
 * PemeriksaanModel
 */
@Entity
@Table(name = "pemeriksaan")
public class PemeriksaanModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pasien", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PasienModel pasien;

    @NotNull
    @Column(name = "tanggal_pengajuan", nullable = false)
    private Date tanggal_pengajuan;


    @NotNull
    @Column(name = "tanggal_pemeriksaan", nullable = false)
    private Date tanggal_pemeriksaan;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jenis", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JenisPemeriksaanModel jenis_pemeriksaan;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_jadwal", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JadwalJagaModel jadwal_jaga;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull
    @Size(max = 255)
    @Column(name = "hasil", nullable = false)
    private String hasil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PasienModel getPasien() {
        return pasien;
    }

    public void setPasien(PasienModel pasien) {
        this.pasien = pasien;
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

    public JenisPemeriksaanModel getJenis_pemeriksaan() {
        return jenis_pemeriksaan;
    }

    public void setJenis_pemeriksaan(JenisPemeriksaanModel jenis_pemeriksaan) {
        this.jenis_pemeriksaan = jenis_pemeriksaan;
    }

    public JadwalJagaModel getJadwal_jaga() {
        return jadwal_jaga;
    }

    public void setJadwal_jaga(JadwalJagaModel jadwal_jaga) {
        this.jadwal_jaga = jadwal_jaga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }
}