package com.socialmedia.SocialMediaAPI.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.SocialMediaAPI.Entity.Comment;
import com.socialmedia.SocialMediaAPI.Service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@PostMapping("/save")
	private Comment saveComment(@RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}
	
	@GetMapping("/find/byPost")
	private ArrayList<Comment> findCommentByPostID(@RequestParam Long postID){
		return commentService.findCommentByPostID(postID);
	}
	
	@GetMapping("/find/byUser")
	private ArrayList<Comment> findCommentByUserID(@RequestParam String userID){
		return commentService.findCommentByUserID(userID);
	}
}
