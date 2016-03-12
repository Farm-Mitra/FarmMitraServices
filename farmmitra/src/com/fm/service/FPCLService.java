package com.fm.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;

import com.fm.dao.FPCLDAO;
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
		List<FarmVillage> farmVillages = convertPOJOListFV(fvs);
		return farmVillages;
	}
	
	private List<FarmVillage> convertPOJOListFV(List<com.fm.bean.FarmVillage> fvs) {
		List<FarmVillage> fnew = new ArrayList();

		for (com.fm.bean.FarmVillage f : fvs) {
			FarmVillage fn = new FarmVillage();
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

	@Path("{fpclid}/farmer")
	@GET	
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Farmer> getFarmerForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.Farmer> fms = dao.getFarmerForFpcl(Long.parseLong(fpclid));
		List<Farmer> farmers = convertPOJOListF(fms);
		return farmers;
	}
	
	

	public static List<Farmer> convertPOJOListF(List<com.fm.bean.Farmer> fs) {
		List<Farmer> fnew = new ArrayList();

		for (com.fm.bean.Farmer f : fs) {
			Farmer fn = new Farmer();
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
