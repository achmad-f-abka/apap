package com.apap.rscs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * LabSuppliesModel
 */
@Entity
@Table(name = "lab_supplies")
public class LabSuppliesModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 255)
	@Column(name = "kindOf", nullable = false)
	private String kindOf;

	@NotNull
	@Size(max = 255)
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Column(name = "total", nullable = false)
	private int total;

	@NotNull
	@Size(max = 255)
	@Column(name = "description", nullable = false)
	private String description;

	/*gak perlu ada disini, relasi cukup didefinisikan di table yang merujuk ke lab_supplies*/

	/*@ManyToMany(mappedBy = "listLabSupplies", fetch = FetchType.LAZY)
	private Set<JenisPemeriksaanModel> listJenisPemeriksaaan = new HashSet<JenisPemeriksaanModel>();*/	
	
	
	/**
     * @return the id
     */
	public long getId() {
		return id;
	}

	/**
     * @param id the id to set
     */
	public void setId(long id) {
		this.id = id;
	}

	/**
     * @return the kindOf
     */
	public String getKindOf() {
		return kindOf;
	}

	/**
     * @param kindOf the kindOf to set
     */
	public void setKindOf(String kindOf) {
		this.kindOf = kindOf;
	}

	/**
     * @return the name
     */
	public String getName() {
		return name;
	}

	/**
     * @param name the name to set
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * @return the total
     */
	public int getTotal() {
		return total;
	}

	/**
     * @param total the total to set
     */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
     * @return the description
     */
	public String getDescription() {
		return description;
	}

	/**
     * @param description the description to set
     */
	public void setDescription(String description) {
		this.description = description;
	}
}
