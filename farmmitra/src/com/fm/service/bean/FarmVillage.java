package com.fm.service.bean;

import java.util.Date;

public class FarmVillage {
	
	private Long id;
	private String name;
	private String location;
	private Integer waterCapacity;
	private Date date;
	private int noOfFarms;
	private boolean isPlanned;
	private FarmVillagePlan fVillagePlan;

	public FarmVillage() {
		super();
	}

	public FarmVillage(Long id) {
		super();
		this.id = id;
	}
	
	public FarmVillage(Long id, String name, String location, Integer waterCapacity, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.waterCapacity = waterCapacity;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getWaterCapacity() {
		return waterCapacity;
	}

	public void setWaterCapacity(Integer waterCapacity) {
		this.waterCapacity = waterCapacity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = new Date();
	}

	public int getNoOfFarms() {
		return noOfFarms;
	}

	public void setNoOfFarms(int noOfFarms) {
		this.noOfFarms = noOfFarms;
	}

	public boolean isPlanned() {
		return isPlanned;
	}

	public void setPlanned(boolean isPlanned) {
		this.isPlanned = isPlanned;
	}

	public FarmVillagePlan getfVillagePlan() {
		return fVillagePlan;
	}

	public void setfVillagePlan(FarmVillagePlan fVillagePlan) {
		this.fVillagePlan = fVillagePlan;
	}

	@Override
	public String toString() {
		return "FarmVillage [id=" + id + ", name=" + name + ", location=" + location + ", waterCapacity="
				+ waterCapacity + ", date=" + date + "]";
	}

}
