package com.flagselector.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flagselector.dto.FlagDTO;
import com.flagselector.service.FlagSelectorService;

/**
 * This is the Controller API class that has all the RequestMappings
 * 
 * GET /flags
 * GET /flags/{continent} 
 * GET /flags/{continent}/{country}
 * 
 * @author Neetu Malhotra
 *
 */

@RestController
@RequestMapping("/flags")
public class FlagSelectorApi {
	@Autowired
	private FlagSelectorService flagSelectorService;

	@GetMapping
	public List<FlagDTO> getAllData() {

		return flagSelectorService.getAllData();
	}

	@GetMapping("/{continent}")
	public FlagDTO getDataByContinent(@PathVariable String continent) {

		return flagSelectorService.getDataByContinent(continent);
	}

	@GetMapping("/{continent}/{country}")
	public FlagDTO getDataByContinentAndCountry(@PathVariable String continent, @PathVariable String country) {

		return flagSelectorService.getDataByContinentAndCountry(continent, country);
	}
}
