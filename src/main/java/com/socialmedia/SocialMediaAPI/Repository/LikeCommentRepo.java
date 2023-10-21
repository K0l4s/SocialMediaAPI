package com.socialmedia.SocialMediaAPI.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.SocialMediaAPI.Entity.LikeComment;

@Repository
public interface LikeCommentRepo extends JpaRepository<LikeComment, Long>{
	LikeComment save(LikeComment likecomment);
	ArrayList<LikeComment> findAll();
	ArrayList<LikeComment> findLikeCommentByCommentCommentID(Long commentID);
	ArrayList<LikeComment> findLikeCommentByUserUserIDAndCommentCommentID(String userID, Long commentID);
}
