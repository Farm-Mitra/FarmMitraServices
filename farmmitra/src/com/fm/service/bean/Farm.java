package com.fm.service.bean;

import java.util.Date;

public class Farm {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long fc;

	private String longitude;

	private String lattitude;

	private String farmArea;

	private Date date;
	
	private String farmerName;
	private String farmVillageName;

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

	public void setFarmArea(String farmArea) {
		this.farmArea = farmArea;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmVillageName() {
		return farmVillageName;
	}

	public void setFarmVillageName(String farmVillageName) {
		this.farmVillageName = farmVillageName;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", fc=" + fc + ", longitude=" + longitude + ", lattitude=" + lattitude + ", farmArea="
				+ farmArea + ", date=" + date + ", farmerName=" + farmerName + ", farmVillageName=" + farmVillageName + "]";
	}

}
