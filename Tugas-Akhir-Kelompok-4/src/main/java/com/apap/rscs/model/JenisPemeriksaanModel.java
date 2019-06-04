package com.apap.rscs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "jenis_pemeriksaan")
public class JenisPemeriksaanModel implements Serializable{
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

        @NotNull
        @Size(max = 255)
	    @Column(name = "nama", nullable = false)
	    private String name;
        
	    
        @OneToMany(mappedBy = "jenis_pemeriksaan", fetch = FetchType.LAZY)
    	private List<PemeriksaanModel> listPemeriksaan = new ArrayList<PemeriksaanModel>();
        
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "id_supplies", referencedColumnName = "id")
		@OnDelete(action = OnDeleteAction.CASCADE)
		@JsonIgnore
		private LabSuppliesModel supplies;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public LabSuppliesModel getSupplies() {
		return supplies;
		}

		public void setSupplies(LabSuppliesModel supplies) {
			this.supplies = supplies;
		}
}
