package com.flagselector.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flagselector.dao.FlagSelectorDAO;
import com.flagselector.dto.CountryFlagMappingDTO;
import com.flagselector.dto.FlagDTO;

@Repository
public class FlagSelectorDAOImpl implements FlagSelectorDAO {

	private static final Logger LOG = LoggerFactory.getLogger("FlagSelectorDAOImpl");

	private Map<String, Map<String, CountryFlagMappingDTO>> data;
	private List<FlagDTO> flagDTOList;

	@PostConstruct
	public void initialize() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		File file = null;
		FlagDTO[] flagDTOArray = null;
		try {

			file = ResourceUtils.getFile("classpath:continents.json");
			// Read File Content
			String content = new String(Files.readAllBytes(file.toPath()));
			// Get a Json String
			// System.out.println(content);
			flagDTOArray = mapper.readValue(content, FlagDTO[].class);
			// System.out.println(flagDTOArray.length);

			flagDTOList = Arrays.asList(flagDTOArray);
			// System.out.println(flagDTOList.size());
			// System.out.println(flagDTOList);

			data = new HashMap<>();
			for (FlagDTO flagDTO : flagDTOArray) {
				HashMap<String, CountryFlagMappingDTO> map = new HashMap<>();
				for (CountryFlagMappingDTO mapping : flagDTO.getCountries()) {
					map.put(mapping.getName(), mapping);
				}
				data.put(flagDTO.getContinent(), map);
			}

		} catch (FileNotFoundException e) {
			LOG.error("Continents.json not found", e);
			// e.printStackTrace();
			throw e;
		} catch (IOException e) {
			LOG.error("Parsing of Continents.json had problem.", e);
			// e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<FlagDTO> getAllData() {

		return flagDTOList;
	}

	@Override
	public FlagDTO getDataByContinent(String continent) {
		FlagDTO flagDTO = new FlagDTO();
		if (data.containsKey(continent)) {
			List<CountryFlagMappingDTO> list = new ArrayList<>();
			list.addAll(data.get(continent).values());
			flagDTO.setContinent(continent);
			flagDTO.setCountries(list);
			return flagDTO;
		}

		return null;
	}

	@Override
	public FlagDTO getDataByContinentAndCountry(String continent, String country) {

		FlagDTO flagDTO = new FlagDTO();
		if (data.containsKey(continent)) {
			List<CountryFlagMappingDTO> list = new ArrayList<>();
			if (data.get(continent).get(country) == null) {
				return null;
			}
			list.add(data.get(continent).get(country));
			flagDTO.setContinent(continent);
			flagDTO.setCountries(list);
			return flagDTO;
		}
		return null;
	}

}
