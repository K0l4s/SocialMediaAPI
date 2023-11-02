package com.socialmedia.SocialMediaAPI.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.SocialMediaAPI.Entity.Post;
import com.socialmedia.SocialMediaAPI.Entity.User;
import com.socialmedia.SocialMediaAPI.Service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
	PostService postService;
	@GetMapping("/find/{postID}")
	private Post findByPostID(@PathVariable("postID") Long postID)
	{
		return postService.displayPostMetaData(postID);
	}
	@GetMapping("/findAllPostID")
	private ArrayList<Long> findAllPostID()
	{
		return postService.findAllPostID();
	}
	
	@GetMapping("/findUserPost/{userID}")
	private ArrayList<Long> findUserPostByID(@PathVariable("userID") String userID)
	{
		return postService.findUserPostByUserID(userID);
	}
	
	@PostMapping("/saves")
	private Post submitPost(@RequestBody Post post) {
		return postService.submitPost(post);
	}
	
	@GetMapping("/findAllPhoto")
	private ArrayList<Post> findAllPhotoPost(){
		return postService.findAllPhotoPost();
	}
	
	@GetMapping("/findAllPhotoByUserID")
	private ArrayList<Post> findAllPhotoPostByUserID(@RequestParam String userID){
		return postService.findAllPhotoPostByUserID(userID);
	}
	
	@GetMapping("/recommnedPost")
	private ArrayList<Long> getRecommendPosts(@RequestParam int start,@RequestParam int pageSize) {
		ArrayList<Long> listPostID = new ArrayList<Long>();
		for(Post item : postService.getRecommendedPosts(start, pageSize))
			listPostID.add(item.getPostID());
		return listPostID;
	}
	
	@GetMapping("/recommnedPostByUser")
	private ArrayList<Long> getRecommendPostsByUsers(@RequestParam int start,@RequestParam int pageSize,@RequestParam String userID) {
		ArrayList<Long> listPostID = new ArrayList<Long>();
		for(Post item : postService.getRecommendedPostsByUser(start, pageSize, userID))
			listPostID.add(item.getPostID());
		return listPostID;
	}
}
