package com.fm.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
		List<FarmVillage> data = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(FPCL_FARMVILLAGE_QUERY);
			query.setParameter(0, fpclid);
			data = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return data;
	}

	public List<Farmer> getFarmerForFpcl(long fpclid) {
		List<Farmer> data = new ArrayList<Farmer>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			FPCL f = (FPCL) session.get(FPCL.class, fpclid);
			System.out.println(f.getFarmVillages().size());
			for (FarmVillage fv : f.getFarmVillages()) {
				System.out.println(fv.getFarms().size());
				for (Farm farm : fv.getFarms()) {
					data.add(farm.getFarmer());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return data;
	}

	public List<com.fm.bean.FarmVillage> getFarmForFpcl(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		List<Farmer> l = new FPCLDAO().getFarmerForFpcl(2);
		for (Farmer farmer : l) {
			System.out.println(l.toString());
		}
	}

}
