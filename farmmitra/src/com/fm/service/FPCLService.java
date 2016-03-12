package com.fm.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fm.dao.FPCLDAO;
import com.fm.service.bean.FarmVillage;
import com.fm.util.ServiceUtil;

@Path("/fpcl")
public class FPCLService {
	private FPCLDAO dao = new FPCLDAO();
	
	@Path("{fpclid}/farmvillage")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmVillageForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmVillageForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOList(fvs);
		return farmVillages;
	}
	
	@Path("{fpclid}/farmer")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmerForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmerForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOList(fvs);
		return farmVillages;
	}
		
	@Path("{fpclid}/farm")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOList(fvs);
		return farmVillages;
	}
	
	@Path("{fpclid}/device")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getDeviceForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOList(fvs);
		return farmVillages;
	}
	
	
	
	
	
	@Path("{fpclid}/projectedprofit")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getProjectedProfitforFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOList(fvs);
		return farmVillages;
	}
}
