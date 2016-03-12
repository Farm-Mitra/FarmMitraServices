package com.fm.service.bean;

import java.util.Date;

public class Device {

	private Long id;

	private String deviceName;

	private String deviceMake;

	private Date date;

	public Device() {

	}

	public Device(Long id) {
		super();
		this.id = id;
	}

	public Device(String deviceName, String deviceMake, Date date) {
		super();
		this.deviceName = deviceName;
		this.deviceMake = deviceMake;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceMake() {
		return deviceMake;
	}

	public void setDeviceMake(String deviceMake) {
		this.deviceMake = deviceMake;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
