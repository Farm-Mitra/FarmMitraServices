package com.fm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fm.bean.Crop;
import com.fm.util.HibernateHelper;
import com.fm.util.HibernateUtil;

public class CropDAO {

	String CROP_QUERY_IN = "from Crop crop where crop.id IN (:ids)";

	public List<Crop> getCropsByIds(List<Long> cropIds) {
		List<Crop> data = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(CROP_QUERY_IN);
			query.setParameterList("ids", cropIds);
			data = query.list();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			
		}finally {
			session.close();
		}
		return data;
	}

	public List<Crop> getAllCrops() {
		List<Crop> data = null;
		HibernateHelper helper = new HibernateHelper();
		return helper.list("Crop");

	}
}
