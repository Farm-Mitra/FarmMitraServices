package com.farmmitra.psl.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="soil_character")
public class SoilCharacter {
	private String name;
	private String color;

	public SoilCharacter() {
		super();
	}

	public SoilCharacter(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
