package com.fm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm_village_plan_details")
public class FarmVillagePlanDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "farm_village_plan_id")
	private FarmVillage farmVillagePlanId;

	@OneToOne
	@JoinColumn(name = "farm_id")
	private Farm farm;

	@OneToOne
	@JoinColumn(name = "crop_id")
	private Crop crop;

	public FarmVillagePlanDetail() {
		super();
	}

	public FarmVillagePlanDetail(Long id, FarmVillage farmVillagePlanId, Farm farm, Crop crop) {
		super();
		this.id = id;
		this.farmVillagePlanId = farmVillagePlanId;
		this.farm = farm;
		this.crop = crop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FarmVillage getFarmVillagePlanId() {
		return farmVillagePlanId;
	}

	public void setFarmVillagePlanId(FarmVillage farmVillagePlanId) {
		this.farmVillagePlanId = farmVillagePlanId;
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
