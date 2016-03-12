package com.fm.service.bean;

import java.util.Date;

public class FarmVillage {
	
	private Long id;
	private String name;
	private String location;
	private Integer waterCapacity;
	private Date date;

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

}