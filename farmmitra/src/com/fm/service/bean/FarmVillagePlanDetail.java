package com.fm.service.bean;

public class FarmVillagePlanDetail {

	private Long id;

	private FarmVillagePlan farmVillagePlan;

	private Farm farm;

	private Crop crop;

	public FarmVillagePlanDetail() {
		super();
	}

	public FarmVillagePlanDetail(Long id, FarmVillagePlan farmVillagePlan, Farm farm, Crop crop) {
		super();
		this.id = id;
		this.farmVillagePlan = farmVillagePlan;
		this.farm = farm;
		this.crop = crop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FarmVillagePlan getFarmVillagePlan() {
		return farmVillagePlan;
	}

	public void setFarmVillagePlanId(FarmVillagePlan farmVillagePlan) {
		this.farmVillagePlan = farmVillagePlan;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

}
