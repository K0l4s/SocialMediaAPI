package com.socialmedia.SocialMediaAPI.Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name = "user", uniqueConstraints = {
	    @UniqueConstraint(columnNames = "userName"),
	    @UniqueConstraint(columnNames = "userID")})
public class User {
	
    @Id
    private String userID;

    private String address;
    private String gender;
    private LocalDate dob;
    private String avatarURL;
    
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String userName;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userID, String address, String gender, LocalDate dob, String avatarURL,
			String firstName, String lastName, String userName) {
		super();
		this.userID = userID;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.avatarURL = avatarURL;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
