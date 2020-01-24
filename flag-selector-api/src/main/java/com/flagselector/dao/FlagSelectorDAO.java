package com.flagselector.dao;

import java.util.List;

import com.flagselector.dto.FlagDTO;

/**
 * This is the DAO class To indicate that the class provides mechanism for
 * searching based on various combinations
 * 
 * @author Neetu Malhotra
 *
 */

public interface FlagSelectorDAO {

	public List<FlagDTO> getAllData();

	public FlagDTO getDataByContinent(String continent);

	public FlagDTO getDataByContinentAndCountry(String continent, String country);

}
