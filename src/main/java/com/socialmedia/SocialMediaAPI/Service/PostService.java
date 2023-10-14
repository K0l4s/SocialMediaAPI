package com.socialmedia.SocialMediaAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.Post;
import com.socialmedia.SocialMediaAPI.Entity.User;
import com.socialmedia.SocialMediaAPI.Repository.PostRepo;
import com.socialmedia.SocialMediaAPI.Repository.UserRepo;

@Service
public class PostService {
	@Autowired
	PostRepo postRepo;
	
	public Post submitMetaDataOfUser(Post post) {
		return postRepo.save(post);
	}
	
	public Post displayPostMetaData(Long postID) {
		return postRepo.findByPostID(postID);
	}
	
	public ArrayList<Long> findAllPostID() {
	    ArrayList<Post> listPost = postRepo.findAll();
	    ArrayList<Long> listID = new ArrayList<Long>();
	    for (Post item : listPost) {
	        listID.add(item.getPostID());
	    }
	    return listID;
	}
	
	public ArrayList<Long> findUserPostByUserID(String userID) {
	    ArrayList<Post> listPost = postRepo.findAll();
	    ArrayList<Long> newList = new ArrayList<Long>();
	    for (Post item : listPost) {
	        if (item.getUser().getUserID().equals(userID)) {
	            newList.add(item.getPostID());
	        }
	    }
	    return newList;
	}
	
	public Post submitPost(Post post)
	{
		return postRepo.save(post);
	}
}
