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
@Table(name = "farm_village")
public class FarmVillage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "farm_village_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "water_capacity")
	private Integer waterCapacity;

	@Column(name = "date")
	private Date date;
	
	@Column(name = "device_ip")
	private Date deviceIp;
	
	private Device device;
	
	public Date getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(Date deviceIp) {
		this.deviceIp = deviceIp;
	}

	@ManyToOne
    @JoinColumn(name="fpcl_id")
	private FPCL fpcl;

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

	public FPCL getFpcl() {
		return fpcl;
	}

	public void setFpcl(FPCL fpcl) {
		this.fpcl = fpcl;
	}

	@Override
	public String toString() {
		return "FarmVillage [id=" + id + ", name=" + name + ", location=" + location + ", waterCapacity="
				+ waterCapacity + ", date=" + date + ", fpcl=" + fpcl + "]";
	}

}
