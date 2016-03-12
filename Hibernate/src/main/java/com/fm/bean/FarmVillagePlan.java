package com.fm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToOne
    @JoinColumn(name="farm_id")
	private Farm farm_id;
	
	@OneToOne
    @JoinColumn(name="crop_id")
	private Crop crop_id;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "time")
	private Date time;
	
	@Column(name = "water_available")
	private Long waterAvailable;

}
