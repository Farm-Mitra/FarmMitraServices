package com.fm.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.fm.service.bean.FarmVillage;

public class ServiceUtil {
	public static List convertPOJOList(List fs) {
		List fnew = new ArrayList();

		for (Object f : fs) {
			Object fn = new Object();
			try {
				BeanUtils.copyProperties(fn, f);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fnew.add(fn);
		}
		return fnew;
	}

	public static FarmVillage convertPOJO(Object f) {
		FarmVillage fn = new FarmVillage();
		try {
			BeanUtils.copyProperties(fn, f);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fn;
	}

}
