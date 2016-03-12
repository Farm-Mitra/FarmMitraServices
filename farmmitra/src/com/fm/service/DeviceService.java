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

import com.fm.service.bean.Device;
import com.fm.util.HibernateHelper;
import com.fm.util.ServiceUtil;

@Path("/device")
public class DeviceService {

	HibernateHelper helper = new HibernateHelper();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Device> getDevice() {
		List<Device> list = ServiceUtil.convertPOJOListD(helper.list("Device"));
		return list;
	}

	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Device getDevice(@PathParam("id") String id) {
		Device fv = ServiceUtil.convertPOJO((com.fm.bean.Device) helper.get(com.fm.bean.Device.class, Long.parseLong(id)));
		return fv;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void postDevice(Device data) {
		System.out.println(data);
		helper.create(ServiceUtil.convertPOJODInverse(data));
	}

	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public void putDevice(@PathParam("id") String id, Device data) {
		System.out.println(data);
		data.setId(Long.parseLong(id));
		helper.update(ServiceUtil.convertPOJODInverse(data));
	}

}
