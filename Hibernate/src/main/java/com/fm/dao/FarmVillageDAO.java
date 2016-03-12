package com.fm.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fm.bean.FPCL;
import com.fm.bean.Farm;
import com.fm.bean.FarmVillage;
import com.fm.bean.Farmer;
import com.fm.util.HibernateHelper;
import com.fm.util.HibernateUtil;

public class FarmVillageDAO {
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

	public FarmVillage getFarmVillageById(Long id) {

		HibernateHelper helper = new HibernateHelper();
		FarmVillage village = (com.fm.bean.FarmVillage) helper.get(com.fm.bean.FarmVillage.class, id);
		return village;
	}

	public Set<Farm> getFarmsByFarmVillageId(Long id) {

		Set<Farm> data = new HashSet<Farm>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			FarmVillage f = (FarmVillage) session.get(FarmVillage.class, id);
			for (Farm farm : f.getFarms()) {
				data.add(farm);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return data;
	}
}
