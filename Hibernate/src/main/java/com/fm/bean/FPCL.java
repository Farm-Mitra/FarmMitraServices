package com.fm.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fpcl")
public class FPCL {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fpcl_id")
	private Long id;

	@Column(name = "fpcl_name")
	private String name;

	@Column(name = "fpcl_address")
	private String fpclAddress;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "date")
	private Date date;
	
	@OneToMany(mappedBy="id")
    private Set<FarmVillage> farmVillages;
	
	public FPCL() {
		super();
	}

	public FPCL(Long id) {
		super();
		this.id = id;
	}

	public FPCL(Long id, String name, String fpclAddress, String contactNo, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.fpclAddress = fpclAddress;
		this.contactNo = contactNo;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFpclAddress() {
		return fpclAddress;
	}

	public void setFpclAddress(String fpclAddress) {
		this.fpclAddress = fpclAddress;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = new Date();
	}

	public Set<FarmVillage> getFarmVillages() {
		return farmVillages;
	}

	public void setFarmVillages(Set<FarmVillage> farmVillages) {
		this.farmVillages = farmVillages;
	}

}
