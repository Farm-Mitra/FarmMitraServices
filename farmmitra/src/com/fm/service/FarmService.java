package com.fm.service;

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
import com.fm.util.HibernateHelper;
import com.fm.util.ServiceUtil;

@Path("/farm")
public class FarmService {
	HibernateHelper helper = new HibernateHelper();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Farm> getFarm() {
		List<Farm> list = ServiceUtil.convertPOJOListFm(helper.list("Farm"));
		return list;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Farm getFarm(@PathParam("id") String id) {
		Farm fv = ServiceUtil.convertPOJO((com.fm.bean.Farm) helper.get(com.fm.bean.Farm.class, Long.parseLong(id)));
		return fv;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void postFarm(Farm data) {
		System.out.println(data);
		helper.create(ServiceUtil.convertPOJOFmInverse(data));
	}
	
	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void putFarm(@PathParam("id") String id, Farm data) {
		System.out.println(data);
		data.setId(Long.parseLong(id));
		helper.update(ServiceUtil.convertPOJOFmInverse(data));
	}
}
