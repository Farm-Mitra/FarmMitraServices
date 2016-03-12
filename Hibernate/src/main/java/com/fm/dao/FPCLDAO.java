package com.fm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fm.bean.FarmVillage;
import com.fm.bean.Farmer;
import com.fm.util.HibernateUtil;

public class FPCLDAO {
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
		List<Farmer> data = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(FPCL_FARMER_QUERY);
			query.setParameter(0, fpclid);
			data = query.list();
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

}
