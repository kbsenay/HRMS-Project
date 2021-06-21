package kodlama.io.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CityService;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.City;


@RestController
@RequestMapping("/app/city")
@CrossOrigin
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("getById")
    public DataResult<City> getById(@RequestParam int id){
		return this.cityService.getById(id);
	}
	
	@GetMapping("getAll")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	
}
