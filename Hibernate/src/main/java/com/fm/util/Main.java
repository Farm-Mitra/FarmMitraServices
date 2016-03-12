package com.fm.util;

import java.util.List;

import com.fm.bean.FarmVillage;

public class Main {
//	public static void main(String[] args) {
//
//		Device d = createDevice();
//
//		// Create entry in table
//		HibernateHelper helper = new HibernateHelper();
//		helper.create(d);
//		
//		// Get created entry
//		Device d1 = (Device) helper.get(Device.class, d.getDeviceId());
//		System.out.println(d1.toString());
//		
//		
//		// Get all rows
//		List<Device> l = helper.list("Device");
//		for (Device d3 : l) {
//			System.out.println(d3.toString());
//		}
//
//		// Change a row
//		d.setDeviceLocation("Kof");
//		helper.update(d);
//
//		//Read a row
//		Device d2 = (Device) helper.get(Device.class, d.getDeviceId());
//		System.out.println(d2.toString());
//
//		helper.delete(new Device(4L));
//
//
//		System.out.println("-----Done----");
//	}

	public static void main(String[] args) {

		FarmVillage fv = createFarmVillage();

		// Create entry in table
		HibernateHelper helper = new HibernateHelper();
		helper.create(fv);
		
		// Get created entry
		FarmVillage f1 = (FarmVillage) helper.get(FarmVillage.class, fv.getId());
		System.out.println(f1.toString());
		
		
		// Get all rows
		List<FarmVillage> l = helper.list("FarmVillage");
		for (FarmVillage f3 : l) {
			System.out.println(f3.toString());
		}

		// Change a row
		fv.setLocation("Margao");
		helper.update(fv);

		//Read a row
		FarmVillage f2 = (FarmVillage) helper.get(FarmVillage.class, fv.getId());
		System.out.println(f2.toString());

		helper.delete(new FarmVillage(2L));


		System.out.println("-----Done----");
	}
	
	
	private static FarmVillage createFarmVillage() {
		FarmVillage fv = new FarmVillage();
		fv.setLocation("Vasco");
		fv.setName("Farm1");
		fv.setWaterCapacity(2000);
		return fv;
	}

}
