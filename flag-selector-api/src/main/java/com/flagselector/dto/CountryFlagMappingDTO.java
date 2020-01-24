package com.flagselector.dto;

public class CountryFlagMappingDTO {

	private String name; // name of the country
	private String flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "CountryFlagMappingDTO [name=" + name + ", flag=" + flag + "]";
	}

}
