package com.fm.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;

import com.fm.dao.FarmVillageDAO;
import com.fm.service.bean.FarmVillage;
import com.fm.util.HibernateHelper;

@Path("/farmvillage")
public class FarmVillageService {
	HibernateHelper helper = new HibernateHelper();
	FarmVillageDAO dao = new FarmVillageDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmVillage() {
		List<FarmVillage> list = convertPOJOList(helper.list("FarmVillage"));
		return list;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public FarmVillage getFarmVillage(@PathParam("id") String id) {
		FarmVillage fv = convertPOJO((com.fm.bean.FarmVillage) helper.get(com.fm.bean.FarmVillage.class, Long.parseLong(id)));
		return fv;
	}

	@Path("fpcl/{fpclid}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmVillageForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmVillageForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = convertPOJOList(fvs);
		return farmVillages;
	}

	private List<FarmVillage> convertPOJOList(List<com.fm.bean.FarmVillage> fvs) {
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

	private FarmVillage convertPOJO(com.fm.bean.FarmVillage fv) {
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

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public FarmVillage postFarmVillage(FarmVillage data) {
		System.out.println(data.getName());

		return data;
	}

	public static void main(String[] args) {
		new FarmVillageService().getFarmVillageForFpcl("2");
	}
}