package com.socialmedia.SocialMediaAPI.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.LikeComment;
import com.socialmedia.SocialMediaAPI.Repository.CommentRepo;
import com.socialmedia.SocialMediaAPI.Repository.LikeCommentRepo;
import com.socialmedia.SocialMediaAPI.Repository.UserRepo;

@Service
public class LikeCommentService {
	@Autowired
	LikeCommentRepo likeCommentRe;
	@Autowired
	UserRepo userRepo;
	@Autowired
	CommentRepo commentRepo;

	public boolean isExist(LikeComment like) {
		ArrayList<LikeComment> listLike = likeCommentRe.findAll();
		for (LikeComment likePost : listLike) {
			if (likePost.equals(like))
				return true;
		}
		return false;
	}
	
	public boolean checkExistByUserIDAndCommentID(String userID, Long commentID) {
	    ArrayList<LikeComment> listLike = likeCommentRe.findLikeCommentByUserUserIDAndCommentCommentID(userID, commentID);
	    return !listLike.isEmpty();
	}

	public LikeComment likeComment(String userID, Long commentID) {
		LikeComment like = new LikeComment();
		like.setUser(userRepo.findByUserID(userID));
		like.setComment(commentRepo.findByCommentID(commentID));
		if (isExist(like))
			return null;
			
		else {
			return likeCommentRe.save(like);
		}
	}

	public ArrayList<LikeComment> findLikeCommentByCommentID(Long postID) {
		return likeCommentRe.findLikeCommentByCommentCommentID(postID);
	}

	public boolean deleteLikeComment(String userID, Long commentID) {
		ArrayList<LikeComment> listLike = likeCommentRe.findLikeCommentByUserUserIDAndCommentCommentID(userID, commentID);
		if(listLike.isEmpty())
			return false;
		likeCommentRe.deleteAll(listLike);
		return true;
	}
}
