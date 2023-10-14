package com.socialmedia.SocialMediaAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.User;
import com.socialmedia.SocialMediaAPI.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public User submitMetaDataOfUser(User user) {
		return userRepo.save(user);
	}
	
	public User displayUserMetaData(String userID) {
		return userRepo.findByUserID(userID);
	}
}
