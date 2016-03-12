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
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;

import com.fm.dao.FarmVillageDAO;
import com.fm.service.bean.Farm;
import com.fm.service.bean.FarmVillage;
import com.fm.util.HibernateHelper;
import com.fm.util.ServiceUtil;

@Path("/farmvillage")
public class FarmVillageService {
	HibernateHelper helper = new HibernateHelper();
	FarmVillageDAO dao = new FarmVillageDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmVillage() {
		List<FarmVillage> list = ServiceUtil.convertPOJOList(helper.list("FarmVillage"));
		return list;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public FarmVillage getFarmVillage(@PathParam("id") String id) {
		FarmVillage fv = ServiceUtil
				.convertPOJO((com.fm.bean.FarmVillage) helper.get(com.fm.bean.FarmVillage.class, Long.parseLong(id)));
		return fv;
	}

	@Path("fpcl/{fpclid}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmVillageForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmVillageForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOList(fvs);
		return farmVillages;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public FarmVillage postFarmVillage(FarmVillage data) {
		System.out.println(data.getName());
		// TODO:

		return data;
	}

	@Path("{farm_id}/farm")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Farm> getFarmsByFarmVillage(@PathParam("farm_id") Long farmId) {
		ArrayList<com.fm.bean.Farm> farmList = new ArrayList<com.fm.bean.Farm>();
		farmList.addAll(dao.getFarmsByFarmVillageId(farmId));
		List<Farm> farms = convertPOJOListForFarm(farmList);
		return farms;
	}

	public static List convertPOJOListForFarm(List fs) {
		List<Farm> fnew = new ArrayList();

		for (Object f : fs) {
			Farm fn = new Farm();
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
}
