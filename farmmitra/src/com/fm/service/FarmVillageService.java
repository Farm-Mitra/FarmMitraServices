package com.fm.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fm.dao.FarmVillageDAO;
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
		FarmVillage fv = ServiceUtil.convertPOJO((com.fm.bean.FarmVillage) helper.get(com.fm.bean.FarmVillage.class, Long.parseLong(id)));
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
		//TODO:
		
		return data;
	}
}