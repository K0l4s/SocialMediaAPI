package com.socialmedia.SocialMediaAPI.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.SocialMediaAPI.Entity.City;
import com.socialmedia.SocialMediaAPI.Service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	@Autowired
	CityService citySer;
	
	@GetMapping("/all")
	private ArrayList<City> getAll(){
		return citySer.findAll();
	}
	
	@PostMapping("/add")
	private City addCity(@RequestBody City city) {
		return citySer.addCity(city);
	}
}
