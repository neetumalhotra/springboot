package com.flagselector.dto;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class FlagDTOTest extends EasyMockSupport {

	@TestSubject
	private FlagDTO flagDTO = new FlagDTO();

	@Test
	public void testGetContinent() {
		FlagDTO flagDTO = new FlagDTO();
		flagDTO.setContinent("Africa");

		replayAll();

		String continent = flagDTO.getContinent();
		assertThat(continent, Matchers.is("Africa"));
	}

	@Test
	public void testGetCountries() {
		FlagDTO flagDTO = new FlagDTO();
		CountryFlagMappingDTO countryMappingDTO = new CountryFlagMappingDTO();
		countryMappingDTO.setFlag("f");
		countryMappingDTO.setName("name");
		List<CountryFlagMappingDTO> countries = new ArrayList<>();
		flagDTO.setCountries(countries);

		replayAll();

		List<CountryFlagMappingDTO> countriesReturned = flagDTO.getCountries();
		assertThat(countries, Matchers.is(countriesReturned));
	}
}
