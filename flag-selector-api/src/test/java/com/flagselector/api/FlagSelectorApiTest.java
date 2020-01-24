package com.flagselector.api;

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

import com.flagselector.dto.FlagDTO;
import com.flagselector.service.FlagSelectorService;

@RunWith(EasyMockRunner.class)
public class FlagSelectorApiTest extends EasyMockSupport {

	@TestSubject
	private FlagSelectorApi flagSelectorApi = new FlagSelectorApi();
	
	@Mock
	private FlagSelectorService flagSelectorService;
	
	@Test
	public void testGetAllData() {
		FlagDTO flagDTO = new FlagDTO();
		flagDTO.setContinent("Africa");
		List<FlagDTO> list = new ArrayList<>();
		EasyMock.expect(flagSelectorService.getAllData()).andReturn(list);
		
		replayAll();
		
		List<FlagDTO> listnew = flagSelectorApi.getAllData();
		assertThat(listnew, Matchers.is(list));
	}
	
	@Test
	public void testGetDataByContinent() {
		FlagDTO flagDTO = new FlagDTO();
		//flagDTO.setContinent("Africa");
		
		EasyMock.expect(flagSelectorService.getDataByContinent(EasyMock.anyString())).andReturn(flagDTO);
		
		replayAll();
		
		FlagDTO flagDTOnew = flagSelectorApi.getDataByContinent("Africa");
		assertThat(flagDTOnew, Matchers.is(flagDTO));
	}
	
	@Test
	public void testGetDataByContinentAndCountry() {
		FlagDTO flagDTO = new FlagDTO();
		flagDTO.setContinent("Africa");
		
		EasyMock.expect(flagSelectorService.getDataByContinentAndCountry(EasyMock.anyString(), EasyMock.anyString())).andReturn(flagDTO);
		
		replayAll();
		
		FlagDTO flagDTOnew = flagSelectorApi.getDataByContinentAndCountry("Africa", "Egypt");
		assertThat(flagDTOnew, Matchers.is(flagDTO));
	}
}
