package com.socialmedia.SocialMediaAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.socialmedia.SocialMediaAPI.Entity.LikePost;
import com.socialmedia.SocialMediaAPI.Entity.Post;
import com.socialmedia.SocialMediaAPI.Entity.User;
import com.socialmedia.SocialMediaAPI.Repository.PostRepo;
import com.socialmedia.SocialMediaAPI.Repository.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Service
public class PostService {
	@Autowired
	PostRepo postRepo;
	@Autowired
	UserRepo userRepo;

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

	public Post submitPost(Post post) {
		return postRepo.save(post);
	}

	public boolean deletePost(Long postID) {
		try {
			postRepo.deleteById(postID);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public ArrayList<Post> findAllPhotoPost() {
		return postRepo.findPostImageURLNotNull();
	}

	public ArrayList<Post> findAllPhotoPostByUserID(String userID) {
		return postRepo.findPostImageURLNotNullUser(userID);
	}

	public ArrayList<Post> getRecommendedPosts(int start, int pageSize) {

		PageRequest pageRequest = PageRequest.of(start, pageSize);

		ArrayList<Post> recommendedPosts = postRepo.findRecommendedPosts(pageRequest);
		return recommendedPosts;
	}

	public ArrayList<Post> getRecommendedPostsByUser(int start, int pageSize,String userID) {

		PageRequest pageRequest = PageRequest.of(start, pageSize);

		ArrayList<Post> recommendedPosts = postRepo.findRecommendedPostsByUser(pageRequest,userID);
		return recommendedPosts;
	}
}
