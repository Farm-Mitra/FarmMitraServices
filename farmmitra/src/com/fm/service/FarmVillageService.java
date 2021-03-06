package com.fm.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		List<FarmVillage> list = ServiceUtil.convertPOJOListFV(helper.list("FarmVillage"));
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
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOListFV(fvs);
		return farmVillages;
	}

	@Path("{farmVillageId}/farm")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Farm> getFarmsByFarmVillage(@PathParam("farmVillageId") Long farmVillageId) {
		ArrayList<com.fm.bean.Farm> farmList = new ArrayList<com.fm.bean.Farm>();
		farmList.addAll(dao.getFarmsByFarmVillageId(farmVillageId));
		List<Farm> farms = ServiceUtil.convertPOJOListFm(farmList);
		for (Farm farm : farms) {
			System.out.println(farm.toString());
		}
		return farms;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void postFarmVillage(FarmVillage fv) {
		System.out.println(fv);
		helper.create(ServiceUtil.convertPOJOFvInverse(fv));
	}

	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void putFarmVillage(@PathParam("id") String id, FarmVillage data) {
		System.out.println(data);
		data.setId(Long.parseLong(id));
		helper.update(ServiceUtil.convertPOJOFvInverse(data));
	}
}
