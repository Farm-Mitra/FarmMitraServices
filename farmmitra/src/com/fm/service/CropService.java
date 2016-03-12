package com.fm.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fm.bean.Crop;
import com.fm.bean.FarmVillage;
import com.fm.dao.CropDAO;
import com.fm.dao.FarmVillageDAO;
import com.fm.service.bean.FarmVillagePlan;
import com.fm.service.bean.FarmVillagePlanDetail;
//import com.fm.service.bean.FarmVillagePlan;
import com.fm.util.FarmAllocationUtil;
import com.fm.util.HibernateHelper;
import com.fm.util.ServiceUtil;

@Path("/crop")
public class CropService {
	FarmVillageDAO dao = new FarmVillageDAO();

	CropDAO cropDao = new CropDAO();

	HibernateHelper helper = new HibernateHelper();

	@Path("plan")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<List<Crop>> getFarmVillageForFpcl(@QueryParam("farm_village_id") Long farmId,
			@QueryParam("water_usage") Integer waterUsage, @QueryParam("crop_ids") List<Long> cropIds) {

		FarmVillage village = dao.getFarmVillageById(farmId);
		Integer numberOfFarm = village.getFarms().size();
		//Integer numberOfFarm = 5;
		List<Crop> crops = null;
		if (cropIds != null && !cropIds.isEmpty()) {
			crops = cropDao.getCropsByIds(cropIds);
		} else {
			crops = cropDao.getAllCrops();
		}

		if (waterUsage == null) {
			waterUsage = village.getWaterCapacity();
		}
		if (crops == null) {
			return new ArrayList<List<Crop>>();
		}
		
		return FarmAllocationUtil.getFieldAllocation(crops.toArray((new Crop[crops.size()])), waterUsage, numberOfFarm);

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Crop postCrop(Crop data) {
		System.out.println(data.getName());
		helper.create(data);
		return data;
	}

	@Path("/plan")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createFarmPlan(FarmVillagePlan plan) {
		try {
			// plan = mapper.readValue(jsonString, FarmVillagePlan.class);
			helper.create(ServiceUtil.convertPOJOInverseFvp(plan));
			for (FarmVillagePlanDetail detail : plan.getFarmVillagePlanDetail()) {
				com.fm.bean.FarmVillagePlanDetail farmDetails = new com.fm.bean.FarmVillagePlanDetail();
				farmDetails.setCrop(new Crop(detail.getCrop().getId()));
				farmDetails.setFarm(new com.fm.bean.Farm(detail.getFarm().getId()));
				helper.create(farmDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}