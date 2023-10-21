package com.socialmedia.SocialMediaAPI.Repository;



import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.SocialMediaAPI.Entity.LikePost;
import com.socialmedia.SocialMediaAPI.Entity.Post;
import com.socialmedia.SocialMediaAPI.Entity.User;

@Repository
public interface LikePostRepo extends JpaRepository<LikePost, Long> {
	LikePost save(LikePost likePost);
	ArrayList<LikePost> findAll();
	ArrayList<LikePost> findLikePostByPost(Post post);
	ArrayList<LikePost> findLikePostByUserUserIDAndPostPostID(String userID, Long postID);
}
