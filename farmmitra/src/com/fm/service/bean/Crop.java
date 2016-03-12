package com.fm.service.bean;

public class Crop {
	private Long id;
	private String name;
	private String pwp;
	private Long waterConsumption;
	private String allowedStress;
	private Long weightage;
	private String kc;
	private String yield;
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
