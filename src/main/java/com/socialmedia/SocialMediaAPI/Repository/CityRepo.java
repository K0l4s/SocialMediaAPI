package com.socialmedia.SocialMediaAPI.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.SocialMediaAPI.Entity.City;

@Repository
public interface CityRepo extends CrudRepository<City, Long>{
	ArrayList<City> findAll();
}
