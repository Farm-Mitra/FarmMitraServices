package com.fm.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fm.bean.Crop;
import com.fm.bean.FarmVillage;
import com.fm.dao.CropDAO;
import com.fm.dao.FarmVillageDAO;
import com.fm.util.FarmAllocationUtil;

@Path("/crop")
public class CropService {
	FarmVillageDAO dao = new FarmVillageDAO();
	CropDAO cropDao = new CropDAO();

	@Path("plan")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<List<Crop>> getFarmVillageForFpcl(@QueryParam("farm_id") Long farmId,
			@QueryParam("waterUsage") Integer waterUsage, @QueryParam("cropIds") List<Long> cropIds) {

		FarmVillage village = dao.getFarmVillageById(farmId);
		//Integer numberOfFarm = village.getFarms().size();
		Integer numberOfFarm = 5;
		List<Crop> crops = null;
		if(cropIds != null && !cropIds.isEmpty())
		{
			crops = cropDao.getCropsByIds(cropIds);
		}
		else
		{
			crops = cropDao.getAllCrops();
		}
		
		if (waterUsage == null) {
			waterUsage = village.getWaterCapacity();
		}
		return FarmAllocationUtil.getFieldAllocation(crops.toArray((new Crop[crops.size()])), waterUsage, numberOfFarm);

	}
}