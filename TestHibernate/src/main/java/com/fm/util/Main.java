package com.fm.util;

import java.util.List;

import com.fm.bean.Device;

public class Main {
	public static void main(String[] args) {

		Device d = createDevice();

		// Create entry in table
		HibernateHelper helper = new HibernateHelper();
		helper.create(d);
		
		// Get created entry
		Device d1 = (Device) helper.get(Device.class, d.getDeviceId());
		System.out.println(d1.toString());
		
		
		// Get all rows
		List<Device> l = helper.list("Device");
		for (Device d3 : l) {
			System.out.println(d3.toString());
		}

		// Change a row
		d.setDeviceLocation("Kof");
		helper.update(d);

		//Read a row
		Device d2 = (Device) helper.get(Device.class, d.getDeviceId());
		System.out.println(d2.toString());

		helper.delete(new Device(4L));


		System.out.println("-----Done----");
	}

	private static Device createDevice() {
		Device d = new Device();
		d.setDeviceName("PI2");
		d.setDeviceIP("10.1.1.10");
		d.setDeviceLocation("Farm 2");
		return d;
	}

}
