package com.socialmedia.SocialMediaAPI.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.SocialMediaAPI.Entity.LikeComment;
import com.socialmedia.SocialMediaAPI.Service.LikeCommentService;

@RestController
@RequestMapping("/likeComment")
public class LikeCommentController {
	@Autowired
	LikeCommentService likeCommentService;

	@PostMapping("/saves")
	private LikeComment likeComment(@RequestParam String userID, @RequestParam Long commentID)
	{
		return likeCommentService.likeComment(userID, commentID);
	}
	
	@DeleteMapping("/delete")
	private boolean unlikeComment(@RequestParam String userID, @RequestParam Long commentID)
	{
		return likeCommentService.deleteLikeComment(userID, commentID);
	}
	
	@GetMapping("/findTotal")
	private ArrayList<LikeComment> findTotalCommentByUserID(@RequestParam Long commentID)
	{
		return likeCommentService.findLikeCommentByCommentID(commentID);
	}
	
	@GetMapping("/isLike")
	private boolean isExist(@RequestParam String userID, @RequestParam Long commentID)
	{
		return likeCommentService.checkExistByUserIDAndCommentID(userID, commentID);
	}
}
