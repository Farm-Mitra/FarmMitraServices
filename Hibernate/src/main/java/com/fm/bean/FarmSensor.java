package com.fm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm_sensors")
public class FarmSensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "farm_id", nullable = false)	
	private Device Farm;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sensor_id", nullable = false)
	private Sensor sensor;

	public FarmSensor() {
		
	}
	
	public FarmSensor(Long id) {
		super();
		this.id = id;
	}

}
