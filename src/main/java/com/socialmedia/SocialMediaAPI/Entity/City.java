package com.socialmedia.SocialMediaAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	
	@Id
	@GeneratedValue
	private Long cityID;
	
	private String cityName;
	private String cityMapURL;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(Long cityID, String cityName, String cityMapURL) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
		this.cityMapURL = cityMapURL;
	}
	public Long getcityID() {
		return cityID;
	}
	public void setcityID(Long cityID) {
		this.cityID = cityID;
	}
	public String getcityName() {
		return cityName;
	}
	public void setcityName(String cityName) {
		this.cityName = cityName;
	}
	public String getcityMapURL() {
		return cityMapURL;
	}
	public void setcityMapURL(String cityMapURL) {
		this.cityMapURL = cityMapURL;
	}
}
