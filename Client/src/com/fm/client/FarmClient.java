package com.fm.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fm.client.bean.SoilCharacter;

public class FarmClient {
	public static final String BASE_URI = "http://localhost:8080/FarmMitra/rest";
	public static final String PATH = "soil_character";
	public static final String NAME = "clay";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(BASE_URI);
		WebTarget resourceWebTarget = webTarget.path(PATH);
		WebTarget resourceWebTargetName = resourceWebTarget.path(NAME);

		System.out.println("Client Response \n" + getClientResponse(resourceWebTarget));
		System.out.println("Response \n" + getResponse(resourceWebTarget) + "\n\n");

		System.out.println("Client Response \n" + getClientResponse(resourceWebTargetName));
		System.out.println("Response \n" + getResponse(resourceWebTargetName) + "\n\n");

		SoilCharacter data = new SoilCharacter("Clay1", "yellow");

		System.out.println("Client Response \n" + postClientResponse(resourceWebTarget, data));
		System.out.println("Response \n" + postResponse(resourceWebTarget, data) + "\n\n");
	}

	private static int postClientResponse(WebTarget resource, SoilCharacter data) {
		return resource.request(MediaType.APPLICATION_JSON).post(Entity.entity(data, MediaType.APPLICATION_JSON))
				.getStatus();
	}

	private static String postResponse(WebTarget resource, SoilCharacter data) {
		return resource.request(MediaType.APPLICATION_JSON).post(Entity.entity(data, MediaType.APPLICATION_JSON),
				String.class);
	}

	private static int getClientResponse(WebTarget resource) {
		return resource.request(MediaType.APPLICATION_JSON).get().getStatus();
	}

	private static String getResponse(WebTarget resource) {
		return resource.request(MediaType.APPLICATION_JSON).get(String.class);
	}
}
