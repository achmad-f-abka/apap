package com.apap.TA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * KebutuhanReagenModel
 */
@Entity
@Table(name = "kebutuhan_reagen")
public class KebutuhanReagenModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reagen", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LabSuppliesModel lab_supplies;

    @NotNull
    @Column(name = "tanggal_update", nullable = false)
    private Date tanggal_update;

    @NotNull
    @Column(name = "jumlah", nullable = false)
    private long jumlah;

    @NotNull
    @Column(name = "status", nullable = false)
    private long status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LabSuppliesModel getLab_supplies() {
        return lab_supplies;
    }

    public void setLab_supplies(LabSuppliesModel lab_supplies) {
        this.lab_supplies = lab_supplies;
    }

    public Date getTanggal_update() {
        return tanggal_update;
    }

    public void setTanggal_update(Date tanggal_update) {
        this.tanggal_update = tanggal_update;
    }

    public long getJumlah() {
        return jumlah;
    }

    public void setJumlah(long jumlah) {
        this.jumlah = jumlah;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
