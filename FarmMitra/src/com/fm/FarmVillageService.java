package com.fm;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fm.bean.FarmVillage;

@Path("/soil_character")
public class FarmVillageService {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<FarmVillage> getFarmVillage() {
		List<FarmVillage> list = new ArrayList<FarmVillage>();
		list.add(new FarmVillage("Sandy", "Brown"));
		list.add(new FarmVillage("Clay", "Grey"));
		
		return list;
	}

	@Path("{name}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public FarmVillage getFarmVillage(@PathParam("name") String name) {
		List<FarmVillage> list = new ArrayList<FarmVillage>();
		list.add(new FarmVillage("Sandy Soil", "Brown"));
		list.add(new FarmVillage("Clay", "Grey"));

		for (FarmVillage FarmVillage : list) {
			if (name.equalsIgnoreCase(FarmVillage.getName())) {		
				return FarmVillage;
			}
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public FarmVillage postFarmVillage(FarmVillage data) {
		System.out.println(data.getName());

		return data;
	}
}