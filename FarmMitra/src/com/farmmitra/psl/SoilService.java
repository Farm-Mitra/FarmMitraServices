package com.farmmitra.psl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.farmmitra.psl.bean.SoilCharacter;

@Path("/soil_character")
public class SoilService {
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<SoilCharacter> getSoilCharacter() {
		List<SoilCharacter> list = new ArrayList<SoilCharacter>();
		list.add(new SoilCharacter("Sandy", "Brown"));
		list.add(new SoilCharacter("Clay", "Grey"));
		
		return list;
	}

	@Path("{name}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public SoilCharacter getSoilCharacter(@PathParam("name") String name) {
		List<SoilCharacter> list = new ArrayList<SoilCharacter>();
		list.add(new SoilCharacter("Sandy Soil", "Brown"));
		list.add(new SoilCharacter("Clay", "Grey"));

		for (SoilCharacter soilCharacter : list) {
			if (name.equalsIgnoreCase(soilCharacter.getName())) {		
				return soilCharacter;
			}
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public SoilCharacter postSoilCharacter(SoilCharacter data) {
		System.out.println(data.getName());

		return data;
	}
}