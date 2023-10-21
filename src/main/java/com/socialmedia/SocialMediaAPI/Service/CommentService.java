package com.socialmedia.SocialMediaAPI.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.Comment;
import com.socialmedia.SocialMediaAPI.Repository.CommentRepo;

@Service
public class CommentService {
	@Autowired
	CommentRepo commentRepo;
	
	public Comment saveComment(Comment comment)
	{
		return commentRepo.save(comment);
	}
	
	public ArrayList<Comment> findCommentByPostID(Long postID)
	{
		return commentRepo.findCommentByPostPostID(postID);
	}
	
	public ArrayList<Comment> findCommentByUserID(String userID){
		return commentRepo.findCommentByUserUserID(userID);
	}
}
