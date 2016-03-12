package com.fm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fm.bean.FarmVillage;
import com.fm.util.HibernateUtil;

public class FPCLDAO {
	String FPCL_QUERY = "from FarmVillage fv where fv.fpcl.id = ?";
	
	
	public List<FarmVillage> getFarmVillageForFpcl(Long fpclid) {
		List<FarmVillage> data = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(FPCL_QUERY);
			query.setParameter(0, fpclid);
			data = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return data;
	}


	public List<com.fm.bean.FarmVillage> getFarmerForFpcl(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<com.fm.bean.FarmVillage> getFarmForFpcl(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}

}
