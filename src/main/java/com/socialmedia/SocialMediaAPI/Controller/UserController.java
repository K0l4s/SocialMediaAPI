package com.socialmedia.SocialMediaAPI.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.SocialMediaAPI.Entity.User;
import com.socialmedia.SocialMediaAPI.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saves")
	private User submitUser(@RequestBody User user) {
		return userService.submitMetaDataOfUser(user);
	}
	
	@GetMapping("/{userID}")
	private User getUserDetails(@PathVariable("userID") String userID) {
		return userService.displayUserMetaData(userID);
	}
	
	@GetMapping("/all")
	private ArrayList<User> findAll(){
		return userService.findAllUser();
	}
}
