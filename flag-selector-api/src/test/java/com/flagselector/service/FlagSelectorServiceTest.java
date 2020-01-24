package com.flagselector.service;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.flagselector.dao.FlagSelectorDAO;
import com.flagselector.dto.FlagDTO;

@RunWith(EasyMockRunner.class)
public class FlagSelectorServiceTest extends EasyMockSupport {

	@TestSubject
	private FlagSelectorService flagSelectorService = new FlagSelectorService();

	@Mock
	private FlagSelectorDAO flagSelectorDAO;

	@Test
	public void testGetAllData() {
		FlagDTO flagDTO = new FlagDTO();
		flagDTO.setContinent("Africa");
		List<FlagDTO> list = new ArrayList<>();
		EasyMock.expect(flagSelectorDAO.getAllData()).andReturn(list);

		replayAll();

		List<FlagDTO> listnew = flagSelectorService.getAllData();
		assertThat(listnew, Matchers.is(list));
	}

	@Test
	public void testGetDataByContinent() {
		FlagDTO flagDTO = new FlagDTO();
		
		EasyMock.expect(flagSelectorDAO.getDataByContinent(EasyMock.anyString())).andReturn(flagDTO);

		replayAll();

		FlagDTO flagDTOnew = flagSelectorService.getDataByContinent("Africa");
		assertThat(flagDTOnew, Matchers.is(flagDTO));
	}

	@Test
	public void testGetDataByContinentAndCountry() {
		FlagDTO flagDTO = new FlagDTO();
		flagDTO.setContinent("Africa");

		EasyMock.expect(flagSelectorDAO.getDataByContinentAndCountry(EasyMock.anyString(), EasyMock.anyString()))
				.andReturn(flagDTO);

		replayAll();

		FlagDTO flagDTOnew = flagSelectorService.getDataByContinentAndCountry("Africa", "Egypt");
		assertThat(flagDTOnew, Matchers.is(flagDTO));
	}

}
