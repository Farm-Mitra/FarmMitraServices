package com.fm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm")
public class Farm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "farm_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "fc")
	private Long fc;

	@Column(name = "longt")
	private String longitude;

	@Column(name = "lat")
	private String lattitude;

	@Column(name = "area")
	private String farmArea;

	@Column(name = "date")
	private Date date;
	
	@ManyToOne
    @JoinColumn(name="farm_village_id")
	private FarmVillage farmVillage;
	
	
	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private Farmer farmer;

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public Farm() {

	}

	public Farm(Long id) {
		super();
		this.id = id;
	}

	public Farm(Long fc, String longitude, String lattitude, String farmArea, Date date) {
		super();
		this.fc = fc;
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.farmArea = farmArea;
		this.date = date;
	}

	public Long getFc() {
		return fc;
	}

	public void setFc(Long fc) {
		this.fc = fc;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getFarmArea() {
		return farmArea;
	}

	public void setArea(String farmArea) {
		this.farmArea = farmArea;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public FarmVillage getFarmVillage() {
		return farmVillage;
	}

	public void setFarmVillage(FarmVillage farmVillage) {
		this.farmVillage = farmVillage;
	}

}
