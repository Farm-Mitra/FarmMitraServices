package com.fm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "device_id")
	private Long id;
	
	@Column(name = "device_name")
	private String deviceName;
	
	@Column(name = "device_make")
	private String deviceMake;
	
	@Column(name = "date")
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
