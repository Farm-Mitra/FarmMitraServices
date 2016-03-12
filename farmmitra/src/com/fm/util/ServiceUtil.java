package com.fm.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.fm.service.bean.FarmVillage;

public class ServiceUtil {
	public static List<FarmVillage> convertPOJOList(List<com.fm.bean.FarmVillage> fvs) {
		List<FarmVillage> farmVillages = new ArrayList<FarmVillage>();

		for (com.fm.bean.FarmVillage fv : fvs) {
			System.out.println(fv.toString());
			FarmVillage farmVillage = new FarmVillage();
			try {
				BeanUtils.copyProperties(farmVillage, fv);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(farmVillage.toString());
			farmVillages.add(farmVillage);
		}
		return farmVillages;
	}

	public static FarmVillage convertPOJO(com.fm.bean.FarmVillage fv) {
		System.out.println(fv.toString());
		FarmVillage farmVillage = new FarmVillage();
		try {
			BeanUtils.copyProperties(farmVillage, fv);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(farmVillage.toString());
		return farmVillage;
	}

}
