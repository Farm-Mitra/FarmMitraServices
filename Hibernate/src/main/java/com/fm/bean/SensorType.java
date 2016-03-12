package com.fm.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensors")
public class SensorType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sensor_type_id")
	private Long id;
	
	@Column(name = "sensor_type_name")
	private String sensorTypeName;
	
	@Column(name = "description")
	private String description;
	
	public SensorType() {
		
	}
	
	public SensorType(Long id) {
		super();
		this.id = id;
	}

	public SensorType(String sensorTypeName, String description) {
		super();
		this.sensorTypeName = sensorTypeName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSensorTypeName() {
		return sensorTypeName;
	}

	public void setSensorTypeName(String sensorTypeName) {
		this.sensorTypeName = sensorTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
