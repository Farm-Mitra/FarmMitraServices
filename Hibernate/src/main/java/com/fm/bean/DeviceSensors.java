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
@Table(name = "device_sensors")
public class DeviceSensors {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id", nullable = false)	
	private Device device;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sensor_id", nullable = false)
	private Sensor sensor;
	
	public DeviceSensors() {
		
	}
	
	public DeviceSensors(Long id) {
		super();
		this.id = id;
	}

}
