package com.fm.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fm.service.bean.Farm;
import com.fm.util.HibernateHelper;

@Path("/device")
public class DeviceService {
	
	HibernateHelper helper = new HibernateHelper();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void postDevice(Farm data) {
		System.out.println(data);
		helper.create(data);
	}

}
