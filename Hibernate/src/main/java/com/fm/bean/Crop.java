package com.fm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crop")
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crop_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "pwp")
	private String pwp;
	
	@Column(name = "water_consumption")
	private Long  waterConsumption;
	
	@Column(name = "allowed_stress")
	private String allowedStress;
	
	@Column(name = "weightage")
	private Long  weightage;
	
	@Column(name = "kc")
	private String kc;
	
	@Column(name = "yield")
	private String yield;
	
	@Column(name = "duration")
	private String duration;

	public Crop() {
		
	}
	
	public Crop(Long id) {
		super();
		this.id = id;
	}
	
	public Crop(String name, String pwp, Long waterConsumption, String allowedStress, Long weightage, String kc,
			String yield, String duration) {
		super();
		this.name = name;
		this.pwp = pwp;
		this.waterConsumption = waterConsumption;
		this.allowedStress = allowedStress;
		this.weightage = weightage;
		this.kc = kc;
		this.yield = yield;
		this.duration = duration;
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

	public String getPwp() {
		return pwp;
	}

	public void setPwp(String pwp) {
		this.pwp = pwp;
	}

	public Long getWaterConsumption() {
		return waterConsumption;
	}

	public void setWaterConsumption(Long waterConsumption) {
		this.waterConsumption = waterConsumption;
	}

	public String getAllowedStress() {
		return allowedStress;
	}

	public void setAllowedStress(String allowedStress) {
		this.allowedStress = allowedStress;
	}

	public Long getWeightage() {
		return weightage;
	}

	public void setWeightage(Long weightage) {
		this.weightage = weightage;
	}

	public String getKc() {
		return kc;
	}

	public void setKc(String kc) {
		this.kc = kc;
	}

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}



}
