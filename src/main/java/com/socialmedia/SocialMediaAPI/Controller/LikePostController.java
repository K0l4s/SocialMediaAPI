package com.socialmedia.SocialMediaAPI.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.SocialMediaAPI.Entity.LikePost;
import com.socialmedia.SocialMediaAPI.Service.LikePostService;

@RestController
@RequestMapping("/likePost")
public class LikePostController {
	@Autowired
	LikePostService likePostService;

	@PostMapping("/saves")
	private LikePost likePost(@RequestParam String userID, @RequestParam Long postID)
	{
		return likePostService.likePost(userID, postID);
	}
	
	@DeleteMapping("/delete")
	private boolean unlikePost(@RequestParam String userID, @RequestParam Long postID)
	{
		return likePostService.deleteLikePost(userID, postID);
	}
	
	@GetMapping("/findTotal")
	private ArrayList<LikePost> findUserPostByUserID(@RequestParam Long postID)
	{
		return likePostService.findLikePostByPost(postID);
	}
	
	@GetMapping("/isLike")
	private boolean isExist(@RequestParam String userID, @RequestParam Long postID)
	{
		return likePostService.checkExistByUserIDAndPostID(userID, postID);
	}
}
