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
		List<FarmVillage> farmVillages = convertPOJOListFV(fvs);
		return farmVillages;
	}
	
	private List<FarmVillage> convertPOJOListFV(List<com.fm.bean.FarmVillage> fvs) {
		List<FarmVillage> fnew = new ArrayList<FarmVillage>();

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
		List<Farmer> fnew = new ArrayList<Farmer>();

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
	public List<Farm> getFarmForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.Farm> fvs = dao.getFarmForFpcl(Long.parseLong(fpclid));
		List<Farm> farms = convertPOJOListFm(fvs);
		return farms;
	}
	
	public static List<Farm> convertPOJOListFm(List<com.fm.bean.Farm> fs) {
		List<Farm> fnew = new ArrayList<Farm>();

		for (com.fm.bean.Farm f : fs) {
			Farm fn = new Farm();
			fn.setFarmerName(f.getFarmer().getFarmerName());
			fn.setFarmVillageName(f.getFarmVillage().getName());
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
	
	
	
	@Path("{fpclid}/device")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Device> getDeviceForFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.Device> fvs = dao.getDeviceForFpcl(Long.parseLong(fpclid));
		List<Device> farmVillages = convertPOJOListD(fvs);
		return farmVillages;
	}
	
	public static List<Device> convertPOJOListD(List<com.fm.bean.Device> fs) {
		List<Device> fnew = new ArrayList<Device>();

		for (com.fm.bean.Device f : fs) {
			Device fn = new Device();
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
	
	
	
	
	@Path("{fpclid}/projectedprofit")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FarmVillage> getProjectedProfitforFpcl(@PathParam("fpclid") String fpclid) {
		List<com.fm.bean.FarmVillage> fvs = dao.getFarmVillageForFpcl(Long.parseLong(fpclid));
		List<FarmVillage> farmVillages = ServiceUtil.convertPOJOList(fvs);
		return farmVillages;
	}
	
	

}
