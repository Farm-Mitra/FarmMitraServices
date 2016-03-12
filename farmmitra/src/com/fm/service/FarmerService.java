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

import com.fm.service.bean.Farmer;
import com.fm.util.HibernateHelper;
import com.fm.util.ServiceUtil;

@Path("/farmer")
public class FarmerService {
	HibernateHelper helper = new HibernateHelper();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Farmer> getFarmer() {
		List<Farmer> list = ServiceUtil.convertPOJOListF(helper.list("Farmer"));
		return list;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Farmer getFarmer(@PathParam("id") String id) {
		Farmer fv = ServiceUtil.convertPOJO((com.fm.bean.Farmer) helper.get(com.fm.bean.Farmer.class, Long.parseLong(id)));
		return fv;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void postFarmer(Farmer data) {
		System.out.println(data);
		helper.create(ServiceUtil.convertPOJOFInverse(data));
	}
	
	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void putFarmer(@PathParam("id") String id, Farmer data) {
		System.out.println(data);
		data.setId(Long.parseLong(id));
		helper.update(ServiceUtil.convertPOJOFInverse(data));
	}
}
