package com.fm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm_village_plan_details")
public class FarmVillagePlanDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "farm_village_plan_id")
	private FarmVillagePlan farmVillagePlan;

	@OneToOne
	@JoinColumn(name = "farm_id")
	private Farm farm;

	@OneToOne
	@JoinColumn(name = "crop_id")
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
