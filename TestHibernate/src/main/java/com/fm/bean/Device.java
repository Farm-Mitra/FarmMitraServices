package com.fm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device1")
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "device_id")
	private Long deviceId;

	@Column(name = "device_name")
	private String deviceName;

	@Column(name = "device_ip")
	private String deviceIP;

	@Column(name = "device_location")
	private String deviceLocation;

	public Device() {
		super();
	}

	public Device(Long deviceId) {
		super();
		this.deviceId = deviceId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceIP() {
		return deviceIP;
	}

	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}

	public String getDeviceLocation() {
		return deviceLocation;
	}

	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceIP=" + deviceIP
				+ ", deviceLocation=" + deviceLocation + "]";
	}

}
