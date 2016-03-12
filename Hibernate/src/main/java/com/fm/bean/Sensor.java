package com.fm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensors")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sensor_id")
	private Long id;
	
	@Column(name = "sensor_name")
	private String sensorName;
	
	@Column(name = "sensor_type_id")
	private SensorType sensorType;
	
	@Column(name = "batchno")
	private String batchno;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "topic")
	private String topic;

	public Sensor() {

	}
	
	public Sensor(Long id) {
		super();
		this.id = id;
	}

	public Sensor(String sensorName, SensorType sensorType, String batchno, Date date, String topic) {
		super();
		this.sensorName = sensorName;
		this.sensorType = sensorType;
		this.batchno = batchno;
		this.date = date;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public SensorType getSensorType() {
		return sensorType;
	}

	public void setSensorType(SensorType sensorType) {
		this.sensorType = sensorType;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
