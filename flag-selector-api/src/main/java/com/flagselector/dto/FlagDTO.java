package com.flagselector.dto;

import java.util.List;

public class FlagDTO {

	private String continent;
	private List<CountryFlagMappingDTO> countries;

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public List<CountryFlagMappingDTO> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryFlagMappingDTO> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "FlagDTO [continent=" + continent + ", countries=" + countries + "]";
	}

}
