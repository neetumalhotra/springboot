package com.flagselector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flagselector.dao.FlagSelectorDAO;
import com.flagselector.dto.FlagDTO;

/**
 * This is the Service Class which acts as middle man between the API and the
 * DAO. This class provides the business functionalities.
 * 
 * @author Neetu Malhotra
 *
 */
@Service
public class FlagSelectorService {
	@Autowired
	private FlagSelectorDAO flagSelectorDAO;

	public List<FlagDTO> getAllData() {

		return flagSelectorDAO.getAllData();
	}

	public FlagDTO getDataByContinent(String continent) {

		return flagSelectorDAO.getDataByContinent(continent);
	}

	public FlagDTO getDataByContinentAndCountry(String continent, String country) {

		return flagSelectorDAO.getDataByContinentAndCountry(continent, country);
	}
}
