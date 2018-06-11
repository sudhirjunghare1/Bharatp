package com.nt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phoneNo")
public class PhoneNumber {
	@Id
	@Column(name = "phone")
	private long phone;
	@Column(name = "Type")
	private String typeSim;
	@Column(name = "eDate")
	private Date expDate;
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getTypeSim() {
		return typeSim;
	}
	public void setTypeSim(String typeSim) {
		this.typeSim = typeSim;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "PhoneNumber [phone=" + phone + ", typeSim=" + typeSim + ", expDate=" + expDate + "]";
	}

	}
