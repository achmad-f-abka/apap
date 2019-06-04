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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * KebutuhanReagenModel
 */
@Entity
@Table(name = "\"kebutuhan_reagen\"")
public class KebutuhanReagenModel implements Serializable{
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @NotNull
	    @Column(name = "updatedTime", nullable = true)
	    private Date updatedTime;
	    
	    @NotNull
	    @Column(name = "total", nullable = false)
	    private int total;
	    
	    @NotNull
	    @Column(name = "status", nullable = true)
	    private int status;
	    

	    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	    @JoinColumn(name = "id_reagen")
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private LabSuppliesModel lab_supplies;
		
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
	     * @return the updatedTime
	     */
		public Date getUpdatedTime() {
			return updatedTime;
		}

		/**
	     * @param updatedTime the updatedTime to set
	     */
		public void setUpdatedTime(Date updatedTime) {
			this.updatedTime = updatedTime;
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
	     * @return the status
	     */
		public int getStatus() {
			return status;
		}

		/**
	     * @param status the status to set
	     */
		public void setStatus(int status) {
			this.status = status;
		}

		/**
	     * @return the lab_supplies
	     */
		public LabSuppliesModel getLabSupplies() {
			return lab_supplies;
		}

		/**
	     * @param lab_supplies the lab_supplies to set
	     */
		public void setLabSupplies(LabSuppliesModel labSupplies) {
			this.lab_supplies = labSupplies;
		}
	    
}
