package com.fm.service.bean;

import java.util.Date;

public class Farmer {

	private Long id;
	private String farmerName;
	private String farmerAddress;
	private String contactNno;
	private Date date;

	public Farmer() {

	}

	public Farmer(Long id) {
		super();
		this.id = id;
	}

	public Farmer(String farmerName, String farmerAddress, String contactNno, Date date) {
		super();
		this.farmerName = farmerName;
		this.farmerAddress = farmerAddress;
		this.contactNno = contactNno;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerAddress() {
		return farmerAddress;
	}

	public void setFarmerAddress(String farmerAddress) {
		this.farmerAddress = farmerAddress;
	}

	public String getContactNno() {
		return contactNno;
	}

	public void setContactNno(String contactNno) {
		this.contactNno = contactNno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
