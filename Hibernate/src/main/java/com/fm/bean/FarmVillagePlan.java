package com.fm.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm_village_plan")
public class FarmVillagePlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "farm_plan_id")
	private Long id;	
	
	@OneToOne
    @JoinColumn(name="farm_village_id")
	private FarmVillage farmVillage;	
		
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "water_available")
	private Long waterAvailable;
	
	@OneToMany(mappedBy = "farmVillagePlan")
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

}
