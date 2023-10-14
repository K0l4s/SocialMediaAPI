package com.socialmedia.SocialMediaAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="comment", uniqueConstraints = {@UniqueConstraint(columnNames = "commentID")})
public class Comment {

	@Id
	@GeneratedValue
	private Long commentID;
	
	@ManyToOne
	@JoinColumn(name="postID")
	private Post post;
	
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;


	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comment(Long commentID, Post post, User user) {
		super();
		this.commentID = commentID;
		this.post = post;
		this.user = user;
	}


	public Long getCommentID() {
		return commentID;
	}


	public void setCommentID(Long commentID) {
		this.commentID = commentID;
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
