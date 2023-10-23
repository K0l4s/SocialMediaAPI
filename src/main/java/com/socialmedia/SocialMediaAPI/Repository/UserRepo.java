package com.socialmedia.SocialMediaAPI.Repository;

import org.springframework.stereotype.Repository;

import com.socialmedia.SocialMediaAPI.Entity.User;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	User save(User user);
	User findByUserID(String userID);
	ArrayList<User> findAll();
	
	@Query("SELECT u FROM User u WHERE u.firstName LIKE %:keyword% OR u.lastName LIKE %:keyword% OR u.address LIKE %:keyword%")
	ArrayList<User> findUserByKeyWord(String keyword);
}
