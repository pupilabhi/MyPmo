package com.connectivity.vikray.entity;
// Generated 27 Dec, 2018 3:06:26 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RecievableHistory generated by hbm2java
 */
@Entity
@Table(name = "RECIEVABLE_HISTORY", catalog = "namcrm")
public class RecievableHistory implements java.io.Serializable {

	private long id;
	private Recievable recievable;
	private double recievedAmount;
	private Date recievedOn;
	private String remarks;
	private double tdsAmount;

	public RecievableHistory() {
	}

	public RecievableHistory(long id, double recievedAmount, double tdsAmount) {
		this.id = id;
		this.recievedAmount = recievedAmount;
		this.tdsAmount = tdsAmount;
	}

	public RecievableHistory(long id, Recievable recievable, double recievedAmount, Date recievedOn, String remarks,
			double tdsAmount) {
		this.id = id;
		this.recievable = recievable;
		this.recievedAmount = recievedAmount;
		this.recievedOn = recievedOn;
		this.remarks = remarks;
		this.tdsAmount = tdsAmount;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECIEVABLE_FK")
	public Recievable getRecievable() {
		return this.recievable;
	}

	public void setRecievable(Recievable recievable) {
		this.recievable = recievable;
	}

	@Column(name = "RECIEVED_AMOUNT", nullable = false, precision = 22, scale = 0)
	public double getRecievedAmount() {
		return this.recievedAmount;
	}

	public void setRecievedAmount(double recievedAmount) {
		this.recievedAmount = recievedAmount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECIEVED_ON", length = 19)
	public Date getRecievedOn() {
		return this.recievedOn;
	}

	public void setRecievedOn(Date recievedOn) {
		this.recievedOn = recievedOn;
	}

	@Column(name = "REMARKS", length = 16777215)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "TDS_AMOUNT", nullable = false, precision = 22, scale = 0)
	public double getTdsAmount() {
		return this.tdsAmount;
	}

	public void setTdsAmount(double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

}
