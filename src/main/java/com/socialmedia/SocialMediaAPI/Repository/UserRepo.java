package com.socialmedia.SocialMediaAPI.Repository;

import org.springframework.stereotype.Repository;

import com.socialmedia.SocialMediaAPI.Entity.User;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepo extends CrudRepository <User, String>{
	
	User save(User user);
	User findByUserID(String userID);
}
