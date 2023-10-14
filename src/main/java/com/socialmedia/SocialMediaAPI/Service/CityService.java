package com.socialmedia.SocialMediaAPI.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.City;
import com.socialmedia.SocialMediaAPI.Repository.CityRepo;

@Service
public class CityService {

	@Autowired
	CityRepo cityRepo;
	
	public ArrayList<City> findAll()
	{
		return cityRepo.findAll();	 
	}
}
