package com.socialmedia.SocialMediaAPI.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.LikePost;
import com.socialmedia.SocialMediaAPI.Repository.LikePostRepo;
import com.socialmedia.SocialMediaAPI.Repository.PostRepo;
import com.socialmedia.SocialMediaAPI.Repository.UserRepo;

@Service
public class LikePostService {
	@Autowired
	LikePostRepo likePostRe;
	@Autowired
	UserRepo userRepo;
	@Autowired
	PostRepo postRepo;

	public boolean isExist(LikePost like) {
		ArrayList<LikePost> listLike = likePostRe.findAll();
		for (LikePost likePost : listLike) {
			if (likePost.equals(like))
				return true;
		}
		return false;
	}
	
	public boolean checkExistByUserIDAndPostID(String userID, Long postID) {
	    ArrayList<LikePost> listLike = likePostRe.findLikePostByUserUserIDAndPostPostID(userID, postID);
	    return !listLike.isEmpty();
	}

	public LikePost likePost(String userID, Long postID) {
		LikePost like = new LikePost();
		like.setUser(userRepo.findByUserID(userID));
		like.setPost(postRepo.findByPostID(postID));
		if (isExist(like))
			return null;
			
		else {
			return likePostRe.save(like);
		}
	}

	public ArrayList<LikePost> findLikePostByPost(Long postID) {
		return likePostRe.findLikePostByPost(postRepo.findByPostID(postID));
	}

	public boolean deleteLikePost(String userID, Long postID) {
		ArrayList<LikePost> listLike = likePostRe.findLikePostByUserUserIDAndPostPostID(userID, postID);
		if(listLike.isEmpty())
			return false;
		likePostRe.deleteAll(listLike);
		return true;
	}
	
}
