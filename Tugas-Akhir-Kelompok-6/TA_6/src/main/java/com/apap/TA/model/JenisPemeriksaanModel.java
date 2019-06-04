package com.apap.TA.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * UserRoleModel
 */
@Entity
@Table(name = "jenis_pemeriksaan")
public class JenisPemeriksaanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_supplies", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LabSuppliesModel lab_supplies;


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LabSuppliesModel getLab_supplies() {
        return lab_supplies;
    }

    public void setLab_supplies(LabSuppliesModel lab_supplies) {
        this.lab_supplies = lab_supplies;
    }
}