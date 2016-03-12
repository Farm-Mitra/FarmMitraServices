package com.fm.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.fm.bean.Device;
import com.fm.bean.FPCL;
import com.fm.bean.Farm;
import com.fm.bean.FarmVillage;
import com.fm.bean.Farmer;
import com.fm.util.HibernateHelper;
import com.fm.util.HibernateUtil;

public class FPCLDAO {
	HibernateHelper helper = new HibernateHelper();
	String FPCL_FARMVILLAGE_QUERY = "from FarmVillage fv where fv.fpcl.id = ?";
	String FPCL_FARMER_QUERY = "from Farmer fv where fv.fpcl.id = ?";

	public List<FarmVillage> getFarmVillageForFpcl(Long fpclid) {
		List<FarmVillage> data = new ArrayList<FarmVillage>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			FPCL f = (FPCL) session.get(FPCL.class, fpclid);
			for (FarmVillage farmVillage : f.getFarmVillages()) {
				farmVillage.getFarms();
				//farmVillage.setFarmSize(.size());
				data.add(farmVillage);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return data;
	}

	public List<Farmer> getFarmerForFpcl(long fpclid) {
		Set<Farmer> data = new HashSet<Farmer>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			FPCL f = (FPCL) session.get(FPCL.class, fpclid);
			for (FarmVillage fv : f.getFarmVillages()) {
				for (Farm farm : fv.getFarms()) {
					data.add(farm.getFarmer());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return new ArrayList<Farmer>(data);
	}

	public List<com.fm.bean.Farm> getFarmForFpcl(long fpclid) {
		Set<Farm> data = new HashSet<Farm>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			FPCL f = (FPCL) session.get(FPCL.class, fpclid);
			for (FarmVillage fv : f.getFarmVillages()) {
				for (Farm farm : fv.getFarms()) {
					data.add(farm);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return new ArrayList<Farm>(data);
	}


	public List<com.fm.bean.Device> getDeviceForFpcl(long fpclid) {
		Set<Device> data = new HashSet<Device>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			FPCL f = (FPCL) session.get(FPCL.class, fpclid);
			for (FarmVillage fv : f.getFarmVillages()) {
				data.add(fv.getDevice());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return new ArrayList<Device>(data);
	}

}
