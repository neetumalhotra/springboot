package com.flagselector.dao.impl;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.TestSubject;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.flagselector.dto.FlagDTO;

@RunWith(EasyMockRunner.class)
public class FlagSelectorDAOImplTest extends EasyMockSupport {

	@TestSubject
	private static FlagSelectorDAOImpl flagSelectorDAOImpl = new FlagSelectorDAOImpl();

	@BeforeClass
	public static void setup() throws IOException {
		flagSelectorDAOImpl.initialize();
	}

	@Test
	public void testGetAllData() {
		List<FlagDTO> flagDTO = flagSelectorDAOImpl.getAllData();
		assertThat(flagDTO.size(), Matchers.is(5));
	}

	@Test
	public void testGetDataByContinent() {
		FlagDTO flagDTO = flagSelectorDAOImpl.getDataByContinent("Africa");
		assertThat(flagDTO.getContinent(), Matchers.is("Africa"));
		assertThat(flagDTO.getCountries().size(), Matchers.greaterThan(1));
	}

	@Test
	public void testGetDataByContinentAndCountry() {
		FlagDTO flagDTO = flagSelectorDAOImpl.getDataByContinentAndCountry("Africa", "Egypt");
		assertThat(flagDTO.getContinent(), Matchers.is("Africa"));
		assertThat(flagDTO.getCountries().size(), Matchers.is(1));
		assertThat(flagDTO.getCountries().get(0).getName(), Matchers.is("Egypt"));
	}

	@Test
	public void testGetDataByWrongContinentAndCountry() {
		FlagDTO flagDTO = flagSelectorDAOImpl.getDataByContinentAndCountry("DummyContinent", "Egypt");
		assertThat(flagDTO, Matchers.nullValue());
	}

	@Test
	public void testGetDataByCorrectContinentAndDummyCountry() {
		FlagDTO flagDTO = flagSelectorDAOImpl.getDataByContinentAndCountry("Africa", "DummyCountry");
		assertThat(flagDTO, Matchers.nullValue());
	}

}
