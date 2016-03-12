package com.fm.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fm.dao.FPCLDAO;
import com.fm.service.bean.Capacity;
import com.fm.service.bean.Device;
import com.fm.service.bean.Farm;
import com.fm.service.bean.FarmVillage;
import com.fm.service.bean.Farmer;
import com.fm.util.ServiceUtil;

@Path("/fpcl")
public class FPCLService {
	private FPCLDAO dao = new FPCLDAO();

	@Path("{fpclid}/farmvillage")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmVillageForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmVillageForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOListFV(fvs);
		return farmVillages;
	}

	@Path("{fpclid}/farmer")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Farmer> getFarmerForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.Farmer> fms = dao.getFarmerForFpcl(Long.parseLong(fpclid));
		List<Farmer> farmers = ServiceUtil.convertPOJOListF(fms);
		return farmers;
	}

	@Path("{fpclid}/farm")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Farm> getFarmForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.Farm> fvs = dao.getFarmForFpcl(Long.parseLong(fpclid));
		List<Farm> farms = ServiceUtil.convertPOJOListFm(fvs);
		return farms;
	}

	@Path("{fpclid}/device")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Device> getDeviceForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.Device> fvs = dao.getDeviceForFpcl(Long.parseLong(fpclid));
		List<Device> farmVillages = ServiceUtil.convertPOJOListD(fvs);
		return farmVillages;
	}

	@Path("{fpclid}/waterdetail")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Capacity getWaterDetailsForFpcl(@PathParam("fpclid") String fpclid) {
		int capacity = 0;
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmVillageForFpcl(Long.parseLong(fpclid));
		for (com.fm.bean.FarmVillage farmVillage : fvs) {
			capacity += farmVillage.getWaterCapacity();
		}

		return new Capacity(capacity);
	}

	@Path("{fpclid}/projectedprofit")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getProjectedProfitforFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmVillageForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = null;// convertPOJOList(fvs);
		return farmVillages;
	}

}
