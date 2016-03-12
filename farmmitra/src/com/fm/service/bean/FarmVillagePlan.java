package com.fm.service.bean;

import java.util.Date;
import java.util.Set;

public class FarmVillagePlan {

	private Long id;

	private FarmVillage farmVillage;

	private Date startDate;

	private Date endDate;

	private Date time;

	private Long waterAvailable;

	private Set<FarmVillagePlanDetail> farmVillagePlanDetail;

	public FarmVillagePlan() {
		super();
	}

	public FarmVillagePlan(Long id, FarmVillage farmVillage, Date startDate, Date endDate, Date time,
			Long waterAvailable) {
		super();
		this.id = id;
		this.farmVillage = farmVillage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.time = time;
		this.waterAvailable = waterAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FarmVillage getFarmVillage() {
		return farmVillage;
	}

	public void setFarmVillage(FarmVillage farmVillage) {
		this.farmVillage = farmVillage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getWaterAvailable() {
		return waterAvailable;
	}

	public void setWaterAvailable(Long waterAvailable) {
		this.waterAvailable = waterAvailable;
	}

	public Set<FarmVillagePlanDetail> getFarmVillagePlanDetail() {
		return farmVillagePlanDetail;
	}

	public void setFarmVillagePlanDetail(Set<FarmVillagePlanDetail> farmVillagePlanDetail) {
		this.farmVillagePlanDetail = farmVillagePlanDetail;
	}

}
