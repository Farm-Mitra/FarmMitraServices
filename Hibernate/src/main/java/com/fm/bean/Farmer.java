package com.fm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farmers")
public class Farmer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "farmer_id")
	private Long id;
	  
	@Column (name = "farmer_name")
	private String farmerName;
	
	@Column (name = "farmer_address")
	private String farmerAddress;
	
	@Column (name = "contact_no")
	private String  contactNno;
	
	@Column (name = "date")
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
