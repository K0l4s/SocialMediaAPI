package com.socialmedia.SocialMediaAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="like_post", uniqueConstraints = {@UniqueConstraint(columnNames = "likePostID")})
public class LikePost {
	@Id
	@GeneratedValue
	private Long likePostID;
	
	@ManyToOne
	@JoinColumn(name="postID")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public LikePost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikePost(Long likePostID, Post post, User user) {
		super();
		this.likePostID = likePostID;
		this.post = post;
		this.user = user;
	}

	public Long getLikePostID() {
		return likePostID;
	}

	public void setLikePostID(Long likePostID) {
		this.likePostID = likePostID;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
